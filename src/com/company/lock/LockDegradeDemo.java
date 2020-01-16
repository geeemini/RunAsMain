package com.company.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2020/1/16 15:46
 * 有内鬼，中止交易
 */
public class LockDegradeDemo {

    private int i = 0;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();

    public void doSomething(){
        writeLock.lock();
        readLock.lock();
        try {
            i++;
        }finally {
            writeLock.unlock();
        }


        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            if(i ==1){
                System.out.println("i的值为==="+i);
            }else {
                System.out.println("正常输出："+i);
            }
        }finally {
            readLock.unlock();
        }


    }

    public static void main(String[] args) {
        LockDegradeDemo degradeDemo = new LockDegradeDemo();
        for (int i = 0; i < 4; i++) {
            new Thread(()->{
                degradeDemo.doSomething();
            }).start();
        }
    }


}
