package com.revature.blockers;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	private int count;

	public void incrementCount() throws InterruptedException {
		int tempCount = count;
		Thread.sleep(10);
		count = tempCount + 1;
	}

	public int getCount() {
		return count;
	}
}
