package com.revature.launchers;

import com.revature.threads.JoinRunnable;

public class JoinLauncher {
	public static void main(String[] args) throws InterruptedException {
		Thread l = new Thread(new JoinRunnable());
		l.start();
		l.sleep(200);
		Thread t = new Thread(new JoinRunnable(l));
		t.start();
		System.out.println("main thread is doing what it needs concurrently");
		System.out.println("now we know thread will have to wait for the other thread to finish");
		
		Thread.sleep(1000);
		System.out.println("t state is: " + t.getState());
		t.join();
		
		System.out.println("this won't execute until the other thread is done");
	}
}
