package com.revature.threads;

public class JoinRunnable implements Runnable {

	private Thread t;

	public JoinRunnable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JoinRunnable(Thread t) {
		super();
		this.t = t;
	}

	@Override
	public void run() {
		try {
			if(t != null) {
				System.out.println("joining");
				t.join();
			}
			System.out.println("thread started");
			Thread.sleep(5000);
			System.out.println("thread is done");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
