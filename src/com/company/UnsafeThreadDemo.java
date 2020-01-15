package com.company;

import java.util.concurrent.CountDownLatch;

public class UnsafeThreadDemo {

    private static Integer num = 0;
    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void  increase(){
            num ++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    increase();
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                countDownLatch.countDown();
            }).start();
        }
        while (true){
            if(countDownLatch.getCount() == 0){
                System.out.println(num);
                break;
            }
        }
    }


}
