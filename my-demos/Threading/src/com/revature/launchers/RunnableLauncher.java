package com.revature.launchers;

import com.revature.blockers.BlockingClass;
import com.revature.threads.MyRunnable;

public class RunnableLauncher {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new MyRunnable());
		System.out.println("we just created the thread state is:  " + t.getState());
		t.start();
		System.out.println("now we have started the thread and it is running state is: " +t.getState());
		Thread.sleep(200);
		System.out.println("now the thread hopefully is sleeping state is: " + t.getState());

		while(true) {
			System.out.println("main thread: " + Thread.currentThread().getName());
			Thread.sleep(1000);
		}
	}
}
