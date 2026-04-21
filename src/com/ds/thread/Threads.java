package com.ds.thread;

class Test {
    public static void main(String arg[]) {
        Thread t = Thread.currentThread();
        System.out.println(t);
        t.setName("test thread");
        System.out.println(t);
    }
}
//the output of this program will give the thread's name that is "main", its priority that is 5 and its representation. The priorities of thread are between 1 and 10 the normal priority is
//5. Now we will see how we create threads from extending thread class.

class newthread extends Thread {
    public newthread() {
        super("demo thread");
        System.out.println("child thread:" + this);
        start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("child thread:" + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("child interrupted");
        }
        System.out.println("exiting child thread");
    }
}

public class Threads {
    public static void main(String arg[]) {
        new newthread();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("main thread:" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("main thread interrupted");
        }
        System.out.println("main thread exiting");
    }
}