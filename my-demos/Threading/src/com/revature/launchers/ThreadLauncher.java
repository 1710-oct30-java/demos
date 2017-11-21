package com.revature.launchers;

import com.revature.threads.MyThread;

public class ThreadLauncher {
	public static void main(String[] args) throws InterruptedException {
		MyThread mt = new MyThread();
		mt.start();
		
		while(true) {
			System.out.println("main thread: " + Thread.currentThread().getName());
			new MyThread().start();
			Thread.sleep(1000);
		}
	}
}
