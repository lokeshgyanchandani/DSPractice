package com.ds.array;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
    public static void main(String[] args)
    {

        // Creating a ScheduledThreadPoolExecutor object
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);

        // Creating two Runnable objects
        Runnable task1 = new Command("task1");
        Runnable task2 = new Command("task2");

        // Printing the current time in seconds
        System.out.println("Current time:" + Calendar.getInstance().get(Calendar.SECOND));

        // Scheduling the first task which will execute
        // after 2 seconds and then repeats periodically with
        // a period of 8 seconds
        threadPool.scheduleAtFixedRate(task1, 2, 8, TimeUnit.SECONDS);

        // Scheduling the second task which will execute
        // after 5 seconds and then there will be a delay of
        // 5 seconds between the completion
        // of one execution and the commencement of the next
        // execution
        threadPool.scheduleWithFixedDelay(task2, 5, 5, TimeUnit.SECONDS);

        // Wait for 30 seconds
        /*try {
            System.out.println("Sleeping main thread now");
            Thread.sleep(5000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }*/

        // Remember to shut sown the Thread Pool
        //threadPool.shutdown();

        System.out.println("End");
    }
}

// Class that implements Runnable interface
class Command implements Runnable {
    String taskName;
    public Command(String taskName)
    {
        this.taskName = taskName;
    }
    public void run()
    {
        try {
            System.out.println("Task name : "
                    + this.taskName
                    + " Current time : "
                    + Calendar.getInstance().get(
                    Calendar.SECOND));
            Thread.sleep(2000);
            System.out.println("Executed : " + this.taskName
                    + " Current time : "
                    + Calendar.getInstance().get(
                    Calendar.SECOND));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}