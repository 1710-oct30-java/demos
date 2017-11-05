package com.revature.threads;

public class MyThread extends Thread {
	
	@Override
	public synchronized void start() {
		System.out.println("my custom functionality");
		super.start();
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("this is my thread: " + Thread.currentThread().getName());
				Thread.sleep(500);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
