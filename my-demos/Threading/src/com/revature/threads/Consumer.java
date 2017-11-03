package com.revature.threads;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private BlockingQueue<Object> bq;

	public Consumer(BlockingQueue<Object> bq) {
		super();
		this.bq = bq;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 2000; i++) {
				bq.take();
				System.out.println("consumed item " + i);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
