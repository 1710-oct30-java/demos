package com.revature.threads;

import com.revature.blockers.BlockingClass;

public class BlockingRunnable implements Runnable {
	private BlockingClass bc;

	public BlockingRunnable(BlockingClass bc) {
		super();
		this.bc = bc;
	}

	@Override
	public void run() {
		try {
			bc.blockingMethod();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
