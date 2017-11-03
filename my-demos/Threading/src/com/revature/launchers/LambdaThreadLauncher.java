package com.revature.launchers;

public class LambdaThreadLauncher {
	public static void main(String[] args) {
		while(true) {
			Thread t = new Thread(() -> {
				try {
					Thread.sleep(1000);
					System.out.println("hello from: " + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			t.start();
		}
	}
}
