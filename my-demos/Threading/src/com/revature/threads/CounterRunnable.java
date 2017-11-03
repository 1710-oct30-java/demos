package com.revature.threads;

import com.revature.blockers.Counter;

public class CounterRunnable implements Runnable {
	private Counter count;

	public CounterRunnable(Counter count) {
		super();
		this.count = count;
	}

	public CounterRunnable() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		try {
			for(int i = 0; i < 100; i++) {
				count.incrementCount();
			}
			System.out.println("count is: " + count.getCount());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
