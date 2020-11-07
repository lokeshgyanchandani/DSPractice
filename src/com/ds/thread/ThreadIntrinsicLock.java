package multithreading;

public class ThreadIntrinsicLock {
	private int count = 0;
//	Object lock = new Object();
	public synchronized void increment()
	{
	//	synchronized (lock) {
			count++;
	//	}
		
	}
	
	public static void main(String[] args) {
		ThreadIntrinsicLock til = new ThreadIntrinsicLock();
		til.doWork();
		
		til.increment();
		til.increment();
		til.increment();
		til.increment();
		System.out.println("Count: "+til.count);
	}
	
	public void doWork()
	{
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 10000; i++)
					increment();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 10000; i++)
					increment();
			}
		});
		
		t1.start();
		t2.start();
		try
		{
			t1.join();
			t2.join();
		}
		catch(InterruptedException ie)
		{
			
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Count: "+count);
	}

}
