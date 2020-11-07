package multithreading;

import java.util.Scanner;

class Processor extends Thread {
//	Essentially, volatile is used to indicate that a variable's value will be modified by 
//	different threads.
//	Declaring a volatile Java variable means:
//	The value of this variable will never be cached thread-locally: all reads and writes will go
//	straight to "main memory";
//	Access to the variable acts as though it is enclosed in a synchronized block, synchronized on itself.
	private volatile boolean running = true;
	@Override
	public void run()
	{
		while(running)
		{
			System.out.println("Hello");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void shutdown()
	{
		System.out.println("Shutting down");
		running = false;
	}
}

public class ThreadVolatileDemo {
	public static void main(String[] args)
	{
		Processor p = new Processor();
		p.start();
		System.out.println("Press return to Stop..");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		p.shutdown();
		sc.close();
	}
}
