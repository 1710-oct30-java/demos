package com.revature.threads;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private BlockingQueue<Object> bq;

	public Producer(BlockingQueue<Object> bq) {
		super();
		this.bq = bq;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 2000; i++) {
				System.out.println("created object " + i);
				bq.add(new Object());
				Thread.sleep(50);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
