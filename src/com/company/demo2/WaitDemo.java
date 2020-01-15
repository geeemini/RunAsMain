package com.company.demo2;

import com.sun.xml.internal.stream.util.ThreadLocalBufferAllocator;

import java.io.IOException;

public class WaitDemo implements Runnable {

    private static Object obj = new Object();

    @Override
    public void run() {
        synchronized (obj){
            System.out.println(Thread.currentThread().getName()+"准备执行wait方法");
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"结束执行wait方法");
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Thread thread = new Thread(new WaitDemo(),"对比线程1");
        thread.start();

        Thread thread1 = new Thread(new WaitDemo(),"对比线程2");
        thread1.start();
        Thread.sleep(3000L);
        synchronized (obj){
            obj.notify();
            obj.notify();
        }
        System.in.read();
    }


}
