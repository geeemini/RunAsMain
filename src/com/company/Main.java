package com.company;

import java.util.Calendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        MyWaitNotify test = new MyWaitNotify();
        test.dowait();

        test.doNotify();

    }

    public static void testThread(){
        MyThread myThread = new MyThread();
        myThread.start();

        Thread myThread2 = new Thread(){
            @Override
            public void run() {
                System.out.println("匿名内部类 Thread run 了");
            }
        };
        myThread2.start();
    }

    public static void testRunnable(){
        Thread thread1 = new Thread(new MyRunnable());
        thread1.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类 Runnable run 了");
            }
        };
        Thread thread2 = new Thread(runnable);
        thread2.start();

    }
}
