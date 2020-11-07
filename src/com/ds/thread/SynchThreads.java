package com.ds.thread;

import java.lang.*;

class MyThread implements Runnable {
    String ThreadName;
    int flag;

    MyThread(String name) {
        flag = 0;
        ThreadName = name;
    }

    public void run() {
        flag = 1;
        try {
            synchronized (this) {
                for (int i = 0; i < 10; i++) {

                    System.out.println(ThreadName + "count is " + i);
                }

                System.out.println(ThreadName + " terminating.");
            }
        } catch (Exception exc) {
            System.out.println(ThreadName + " interrupted.");
        }
        flag = 0;
    }
}

public class SynchThreads {
    public static void main(String[] args) {
        System.out.println("Main thread starting.");

        MyThread th1 = new MyThread("thread1");
        MyThread th2 = new MyThread("thread2");

        Thread newth1 = new Thread(th1);
        newth1.start();
        Thread newth2 = new Thread(th2);
        newth2.start();


        do {
            try {
                System.out.println(".");
                Thread.sleep(500);
            } catch (InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        }
        while (th1.flag == 1 || th2.flag == 1);

        System.out.println("Main thread ending.");
    }
}
