package com.company.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/18 15:51
 * 有内鬼，中止交易
 */
public class ReentrantReadWriteLockDemo {

    private int i;
    private int j;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();


    public void increase(){
        writeLock.lock();
        try {
            i++;
//            Thread.sleep(500L);
            j++;
        } finally {
            writeLock.unlock();
        }
    }

    public void out(){
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"i==>"+i+"   j==>"+j);
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();
        /*for (int i = 0; i < 3; i++) {
            new Thread(()->{
                demo.increase();
                demo.out();
            }).start();
        }*/
        /**
         * 写写互斥
         */
        /*new Thread(()->{
            demo.increase();
        },"写锁1").start();
        new Thread(()->{
            demo.increase();
        },"写锁2").start();*/

        /**
         * 读写互斥、写读互斥
         */
        /*new Thread(()->{
            demo.increase();
        },"写锁2").start();
        new Thread(()->{
            demo.out();
        },"读锁1").start();*/

        /**
         * 读读共享
         */
        new Thread(()->{
            demo.out();
        },"读锁2").start();
        new Thread(()->{
            demo.out();
        },"读锁1").start();
    }


}
