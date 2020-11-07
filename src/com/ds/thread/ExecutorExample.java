package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {
	static int count = 0;

	void increment() {
		synchronized (this) {
			count = count + 1;
		}
			
	}

	public static void main(String args[]) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		ExecutorExample x = new ExecutorExample();
		for (int i = 0; i < 10000; i++)
			executor.submit(()->{
                x.increment();
        	});
		
		executor.shutdown();
		System.out.println("All Task Submitted");
		try {
			executor.awaitTermination(26, TimeUnit.SECONDS);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);
		System.out.println("All Task Completed");
	}

}
