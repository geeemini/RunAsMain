package com.company.review;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/2 9:58
 * 有内鬼，中止交易
 */
public class CreateByInner {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },"acc").start();

    }
}
