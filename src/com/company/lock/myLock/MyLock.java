package com.company.lock.myLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/17 15:34
 * 有内鬼，中止交易
 */
public class MyLock implements Lock {

    private boolean isHold = false;

    private Thread currentThread = null;

    private int reentryLock ;

    @Override
    public synchronized void lock() {
        if (isHold && Thread.currentThread() != currentThread){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        isHold = true;
        currentThread = Thread.currentThread();
        reentryLock++;
    }

    @Override
    public synchronized void unlock() {
        if(Thread.currentThread() == currentThread){
            reentryLock--;
            if(reentryLock == 0){
                notify();
                isHold = false;
            }
        }

    }

     @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
