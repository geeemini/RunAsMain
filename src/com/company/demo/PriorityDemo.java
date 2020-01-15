package com.company.demo;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/2 16:17
 * 有内鬼，中止交易
 */
public class PriorityDemo {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName());
            }
        },"线程1");

        Thread thread2 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName());
            }
        },"线程2");

        thread1.setDaemon(true);
        thread1.setPriority(Thread.NORM_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
    }


}
