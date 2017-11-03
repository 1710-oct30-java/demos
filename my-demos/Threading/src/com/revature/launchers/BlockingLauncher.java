package com.revature.launchers;

import com.revature.blockers.BlockingClass;
import com.revature.threads.BlockingRunnable;

public class BlockingLauncher {
	public static void main(String[] args) throws InterruptedException {
		BlockingClass bc = new BlockingClass();
		Thread one = new Thread(new BlockingRunnable(bc));
		Thread two = new Thread(new BlockingRunnable(bc));
		
		one.start();
		Thread.sleep(100);
		two.start();
		Thread.sleep(200);
		
		System.out.println("thread 2 should be blocked its actual state is: " + two.getState());
		
	}
}
