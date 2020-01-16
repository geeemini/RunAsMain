package com.company.communication.demo4;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2020/1/16 19:50
 * 有内鬼，中止交易
 */
public class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"开始运行");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"结束运行");
        },"线程1");

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"结束运行");
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"结束运行");
        },"线程2").start();



    }

}
