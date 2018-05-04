package com.prajaram;

import java.util.Set;

public class Logger {

	static void logInvocation(Object obj,String m) {
		try {
			System.out.println("Invoked:"+obj.getClass()+"Called From:"+StackWalker.getInstance(Set.of(StackWalker.Option.SHOW_HIDDEN_FRAMES,StackWalker.Option.SHOW_REFLECT_FRAMES,StackWalker.Option.RETAIN_CLASS_REFERENCE)).getCallerClass());
			//System.out.println("Invoked:"+obj.getClass()+"-"+obj.getClass().getDeclaredMethod(m).getName());
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
