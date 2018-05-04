package com.prajaram;

import java.util.Set;

public class TestClass {

	public static void hello() {
		System.out.println("Hello World.....!!!"+StackWalker.getInstance(Set.of(StackWalker.Option.SHOW_HIDDEN_FRAMES,StackWalker.Option.SHOW_REFLECT_FRAMES,StackWalker.Option.RETAIN_CLASS_REFERENCE)).getCallerClass());
	}
	public static void main(String[] args) throws InterruptedException {
		hello();
		//System.out.println("Hello World.....!!!"+StackWalker.getInstance(Set.of(StackWalker.Option.SHOW_HIDDEN_FRAMES,StackWalker.Option.SHOW_REFLECT_FRAMES,StackWalker.Option.RETAIN_CLASS_REFERENCE)).getCallerClass());
		System.out.println("Hello World.....!!!");
		Thread.sleep(2000);
	}
}
