package com.revature.launchers;

import com.revature.blockers.DeadLock;

public class DeadLockLauncher {
	public static void main(String[] args) throws InterruptedException {
		DeadLock dl = new DeadLock();
		
		Thread t1 = new Thread(() -> {
			try {
				System.out.println("thread 0 started");
				dl.methodOne(true);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(() -> {
			try {
				System.out.println("thread 1 started");
				dl.methodTwo(true);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t1.start();
		
		t2.start();
		
	}
}
