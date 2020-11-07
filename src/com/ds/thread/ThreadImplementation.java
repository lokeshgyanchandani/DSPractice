package multithreading;


public class ThreadImplementation {
	public static void main(String[] args) throws InterruptedException
	{
		threadDemo td1 = new threadDemo();
		Thread t = new Thread(new Runner());
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		td1.start();
		td1.join();
		t.start();
		t.join();
	//	td2.start();
//		try {
//			
//			
//			
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("End of thread");
	}
}

//Using extends Thread
class threadDemo extends Thread
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++)
		{
			System.out.println("Using Thread " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

//Using implements Runnable
class Runner implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++)
		{
			System.out.println("Using Runnable " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
