package com.revature.launchers;

import com.revature.blockers.Counter;
import com.revature.threads.CounterRunnable;

public class CounterLauncher {
	public static void main(String[] args) throws InterruptedException {
		Counter count = new Counter();
		Thread t = new Thread(new CounterRunnable(count));
		t.start();
		Thread t1 = new Thread(new CounterRunnable(count));
		t1.start();
		
		Thread.sleep(10000);
		System.out.println(t.getState());
	}
}
