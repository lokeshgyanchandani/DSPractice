package com.ds.thread;

import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueue {

	public static void main(String[] args) {
		LinkedBlockingQueue SharedObject = new LinkedBlockingQueue();
		int capacity = 10;

		Thread producer = new Thread(new ProducerThread1(SharedObject, capacity), "producer");
		Thread consumer = new Thread(new ConsumerThread1(SharedObject, capacity), "consumer");
		producer.start();
		consumer.start();

	}
}

class ProducerThread1 implements Runnable {
	final LinkedBlockingQueue SharedObject;
	int size;

	public ProducerThread1(LinkedBlockingQueue sharedObject2, int size) {
		this.SharedObject = sharedObject2;
		this.size = size;
	}

	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			System.out.println("produced thread " + i);
			try {
				SharedObject.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

class ConsumerThread1 implements Runnable {
	final LinkedBlockingQueue SharedObject;
	int size;

	public ConsumerThread1(LinkedBlockingQueue sharedObject2, int size) {
		this.SharedObject = sharedObject2;
		this.size = size;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("consumed " + SharedObject.take());
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
