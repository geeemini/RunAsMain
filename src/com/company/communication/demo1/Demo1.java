package com.company.communication.demo1;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2020/1/16 17:56
 * 有内鬼，中止交易
 */
public class Demo1 {

    private static volatile boolean flag = false;

    private static Object obj = new Object();

    public static void main(String[] args) {

        new Thread(()->{
            synchronized (obj){
                while (!flag){
                    System.out.println("flag is false");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("flag is true!");

        }).start();

        new Thread(()->{
            synchronized (obj){
                while (!flag){
                    System.out.println("flag is false");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("flag is true!");

        }).start();

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            synchronized (obj){
                flag = true;
                obj.notify();
//                obj.notifyAll();
            }
        }).start();


    }


}
