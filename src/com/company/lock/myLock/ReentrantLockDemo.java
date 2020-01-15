package com.company.lock.myLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/18 14:23
 * 有内鬼，中止交易
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
    }

}
