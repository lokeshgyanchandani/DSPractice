package multithreading;
public class ThreadSequentialExecution {
	public int status = 1;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ThreadSequentialExecution tse = new ThreadSequentialExecution();
		Object lock1 = new Object();
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					synchronized (lock1) {
						while(tse.status  != 1) {
							try {
								lock1.wait();
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
						System.out.println("Thread 1");
						tse.status = 2;
						lock1.notifyAll();
					}
				}
				
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					synchronized (lock1) {
						while(tse.status != 2) {
							try {
								lock1.wait();
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						System.out.println("Thread 2");
						tse.status = 3;
						lock1.notifyAll();
					}
				}
				
			}
		});

		Thread thread3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					synchronized (lock1) {
						while(tse.status  != 3) {
							try {
								lock1.wait();
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
						System.out.println("Thread 3");
						tse.status = 1;
						lock1.notifyAll();
					}
				}
			}
		});
		
		thread1.start();
		thread2.start();
		thread3.start();

	}

}
