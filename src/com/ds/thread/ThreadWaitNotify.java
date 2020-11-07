package multithreading;

public class ThreadWaitNotify {

	public static void main(String[] args) {
		Object lock1 = new Object();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
					System.out.println("t1 running");
					synchronized (lock1) {
					try {
						System.out.println("Running wait");
						lock1.wait();
						System.out.println("I'm awake!!!");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("completed t1");
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("t2 running");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				synchronized (lock1) {
						System.out.println("Notifying to wake up t1");
						lock1.notify();
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				System.out.println("completed t2");
			}
		});
		t1.start();
		t2.start();
	}

}
