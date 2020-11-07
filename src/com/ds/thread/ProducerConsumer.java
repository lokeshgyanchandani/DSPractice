package multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

	public static void main(String[] args) {
		Queue SharedObject = new LinkedList<>();
		int capacity = 10;

		Thread producer = new Thread(new ProducerThread(SharedObject, capacity), "producer");
		Thread consumer = new Thread(new ConsumerThread(SharedObject, capacity), "consumer");
		producer.start();
		consumer.start();

	}
}

class ProducerThread implements Runnable {
	final Queue SharedObject;
	int size;

	public ProducerThread(Queue queue, int size) {
		this.SharedObject = queue;
		this.size = size;
	}

	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			System.out.println("produced thread " + i);
			try {
				produce(i);
			} catch (InterruptedException ex) {
			}

		}

	}

	private void produce(int i) throws InterruptedException {
		while (SharedObject.size() == size) {
			synchronized (SharedObject) {
				System.out.println("queue is full");
				SharedObject.wait();
			}
		}
		synchronized (SharedObject) {
			SharedObject.offer(i);
			SharedObject.notifyAll();
		}
	}

}

class ConsumerThread implements Runnable {
	final Queue SharedObject;
	int size;

	public ConsumerThread(Queue queue, int size) {
		this.SharedObject = queue;
		this.size = size;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("consumed " +consume());
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	private Object consume() throws InterruptedException {
		while (SharedObject.isEmpty()) {
			synchronized (SharedObject) {
					System.out.println("queue is empty");
					SharedObject.wait();
			}
		}
		synchronized (SharedObject) {

			SharedObject.notifyAll();
			return SharedObject.poll();
		}

	}
}
