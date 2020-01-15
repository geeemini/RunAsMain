package com.company.review;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/2 9:54
 * 有内鬼，中止交易
 */
public class CreateBylambda {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        },"ppp").start();

    }
}
