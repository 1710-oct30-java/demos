package com.revature.threads;

public class MyRunnable implements Runnable {
	

	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("this is my runnable: " + Thread.currentThread().getName());
				Thread.sleep(500);
				Thread.currentThread().wait();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
}
