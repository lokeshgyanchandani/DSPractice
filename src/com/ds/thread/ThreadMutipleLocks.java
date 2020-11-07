package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadMutipleLocks {
	private Random random = new Random();
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	private Object lock3 = new Object();
	
	
	private static List<Integer> list1 = new ArrayList<Integer>();
	private static List<Integer> list2 = new ArrayList<Integer>();

	public synchronized void dummy1() throws InterruptedException
	{
		Thread.sleep(10000);
	}
	
	public void dummy2() throws InterruptedException
	{
		synchronized(lock3) {
		System.out.println("Hello from the other world");
		}
	}
	public void stageOne() throws InterruptedException
	{
		synchronized (lock1) {
			Thread.sleep(1);
			list1.add(random.nextInt(100));
		}
	}
	
	public void stageTwo() throws InterruptedException
	{
		synchronized(lock1) {
			Thread.sleep(1);
			list2.add(random.nextInt(100));
		}
	}
	
	public void process() throws InterruptedException
	{
	//	dummy1();
		System.out.println(Thread.currentThread());
		for(int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}
	public static void main(String[] args) throws InterruptedException
	{
		ThreadMutipleLocks tml = new ThreadMutipleLocks();
		ThreadMutipleLocks tm2 = new ThreadMutipleLocks();
		System.out.println("Starting time .....");
		long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					tml.process();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					tml.process();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
//		Thread.sleep(1);
		try {
			tml.dummy2();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		long midTime = System.currentTimeMillis();
		System.out.println(midTime - start);
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Time Taken: " + (end-start));
		System.out.println("List1: " + list1.size());
		System.out.println("List2: " + list2.size());
	}
}
