package com.company.lock.myLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/18 15:24
 * 有内鬼，中止交易
 */
public class ReentrantLockDebugDemo {

    private int i;
    private ReentrantLock lock = new ReentrantLock();


    public void increate(){
        lock.lock();
        try {
            i++;
            System.out.println(Thread.currentThread().getName()+":"+i);
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockDebugDemo debugDemo = new ReentrantLockDebugDemo();
        for (int j = 0; j < 3; j++) {
            new Thread(()->{
                debugDemo.increate();
            }).start();
        }
    }



}
