package com.revature.launchers;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.revature.threads.Consumer;
import com.revature.threads.Producer;

public class ProducerConsumerLauncher {
	public static void main(String[] args) {
		BlockingQueue<Object> bq = new LinkedBlockingQueue<>(25);
		Thread producer = new Thread(new Producer(bq));
		Thread consumer = new Thread(new Consumer(bq));
		
		producer.start();
		consumer.start();
		
	}
}
