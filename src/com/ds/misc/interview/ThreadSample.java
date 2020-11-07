package interview;

class Producer extends Thread {
	private tester tester;
	private int number;

	public Producer(tester t, int number) {
		tester = t;
		this.number = number;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			tester.put(i);
			System.out.println("Producer #" + this.number + " put: " + i);

			try {
				sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}
	}
}

class Consumer extends Thread {
	private tester tester;
	private int number;

	public Consumer(tester t, int number) {
		tester = t;
		this.number = number;
	}

	public void run() {
		int value = 0;
		for (int i = 0; i < 5; i++) {
			value = tester.get();
			System.out.println("Consumer #" + this.number + " got: " + value);
		}
	}
}

class tester {
	private int content;
	private boolean available = false;

	public synchronized int get() {
		while (available == false)
			try {
	            wait();
	         }
	         catch (InterruptedException e) {
	         }
		available = false;
		notifyAll();
		return content;
	}

	public synchronized void put(int a) {
		while (available == true)
			try {
	            wait();
	         }
	         catch (InterruptedException e) {
	         }
		content = a;
		available = true;
		notifyAll();
	}

}

public class ThreadSample {

	public static void main(String[] args) {
		tester c = new tester();
		Producer p1 = new Producer(c, 1);
		Consumer c1 = new Consumer(c, 1);
		p1.start();
		c1.start();
	}

}
