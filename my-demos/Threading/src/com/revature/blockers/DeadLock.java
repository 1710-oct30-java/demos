package com.revature.blockers;

public class DeadLock {

	public synchronized void methodOne(boolean b) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " started method 1");
		Thread.sleep(3000);
		if(b) {
			System.out.println(Thread.currentThread().getName() + " is trying to call method 2");
			methodTwo(true);
		}
		System.out.println(Thread.currentThread().getName() + " ended method 1");
	}
	
	public synchronized void methodTwo(boolean b) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " started method 2");
		Thread.sleep(2000);
		if(b) {
			System.out.println(Thread.currentThread().getName() + " is trying to call method 2");
			methodOne(true);
		}
		System.out.println(Thread.currentThread().getName() + " ended method 2");
	}
}
