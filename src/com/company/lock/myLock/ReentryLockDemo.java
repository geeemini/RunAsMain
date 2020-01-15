package com.company.lock.myLock;

import java.util.concurrent.locks.Lock;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/17 15:45
 * 有内鬼，中止交易
 */
public class ReentryLockDemo {
    private Lock lock = new MyLock();

    public void methodA(){
        lock.lock();
        System.out.println("进入方法A");
        methodB();
        lock.unlock();
    }

    public void methodB(){
        lock.lock();
        System.out.println("进入方法B");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentryLockDemo reentryLockDemo = new ReentryLockDemo();
        reentryLockDemo.methodA();
    }
}
