package com.company;

import java.io.IOException;

public class ThreadDemo {

    public static void main(String[] args) throws IOException, InterruptedException {

        // runable
//        new Thread(()->{
//            try {
//                System.in.read();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();

        //BLOCKED
//        Object obj = new Object();
//        new Thread(()->{
//            synchronized (obj){
//                try {
//                    Thread.sleep(111111111111111L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        Thread.sleep(2000L);
//        new Thread(()->{
//            synchronized (obj){
//
//            }
//        }).start();

        //WAITING
        Object obj = new Object();
        new Thread(()->{
            synchronized (obj){
                try {
                    //加了时间就是 TIMED_WAITING
                    //obj.wait(110000000);
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
