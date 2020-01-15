package com.company.demo;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread myThread2 = new MyThread();
        myThread2.setName("myThread - gemini");
        myThread2.start();
    }
}
