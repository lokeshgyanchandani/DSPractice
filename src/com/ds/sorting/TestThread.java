package com.ds.sorting;

class SampleDemo implements Runnable {
    private Thread t;
    private String threadName;

    public SampleDemo(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while (true)
            System.out.println(threadName);
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

public class TestThread {
    public static void main(String[] args) {
        SampleDemo s = new SampleDemo("A");
        SampleDemo s1 = new SampleDemo("B");
        s.start();
        s1.start();
    }
}
