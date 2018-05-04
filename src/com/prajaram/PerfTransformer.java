package com.prajaram;
 	
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class PerfTransformer implements ClassFileTransformer{
	
	@Override
	public byte[] transform(ClassLoader arg0, String arg1, Class<?> arg2, ProtectionDomain arg3, byte[] arg4)
			throws IllegalClassFormatException {
		byte[] byteCode=arg4;
		if(arg1.equals("com/prajaram/TestClass")) {
			System.out.println("Instrument.....starts");
			ClassPool cp=ClassPool.getDefault();
			try {
				CtClass cClass=cp.makeClass(new ByteArrayInputStream(arg4));
				Logger.logInvocation(this, "");
				CtMethod []methods=cClass.getDeclaredMethods();
				for(CtMethod method:methods) {
					method.addLocalVariable("time", CtClass.longType);
					method.insertBefore("com.prajaram.Logger.logInvocation(this, \""+method.getName()+"\");");
					method.insertBefore("time=System.currentTimeMillis();");
					method.insertAfter("System.out.println(\"Time Spent:\"+(System.currentTimeMillis()-time));");
				}
				byteCode=cClass.toBytecode();
				cClass.detach();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CannotCompileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return byteCode;
	}

}
