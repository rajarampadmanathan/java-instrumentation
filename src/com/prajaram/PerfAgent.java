package com.prajaram;

import java.lang.instrument.Instrumentation;

public class PerfAgent {

	public static void premain(String agentArgs,Instrumentation instrumentation) {
		System.out.println("Executing premain...");
		instrumentation.addTransformer(new PerfTransformer());
	}
}
