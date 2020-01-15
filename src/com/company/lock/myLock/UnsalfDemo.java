package com.company.lock.myLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/17 15:19
 * 有内鬼，中止交易
 */
public class UnsalfDemo {

    private static int num ;
    private static CountDownLatch countDownLatch = new CountDownLatch(10);
    private static Lock lock = new MyLock();


    private static void doIncrease(){
        lock.lock();
        num++;
        lock.unlock();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    doIncrease();
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                countDownLatch.countDown();
            }).start();
        }

        for(;;){
            if (countDownLatch.getCount() == 0){
                System.out.println(num);
                break;
            }
        }
    }

}
