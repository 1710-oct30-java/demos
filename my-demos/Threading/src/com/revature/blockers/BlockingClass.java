package com.revature.blockers;

public class BlockingClass {
	public synchronized void blockingMethod() throws InterruptedException {
		System.out.println("Thread: " + Thread.currentThread().getName() + " started synchronized method");
		Thread.sleep(1000);
		System.out.println("Thread: " + Thread.currentThread().getName() + " ended synchronized method");
	}
}
