package com.company.communication.demo2;

/**
 * For:
 *  生产者消费者
 * @Author: gemini
 * @Date: 2020/1/16 18:42
 * 有内鬼，中止交易
 */
public class Main {

    public static void main(String[] args) {

        MiddleMan middleMan = new MiddleMan();

        new Thread(()->{
            middleMan.take();
        },"1").start();
        new Thread(()->{
            middleMan.take();
        },"2").start();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            middleMan.put();
        },"3").start();
//        new Thread(new Consumer(middleMan),"消费者1").start();
//        new Thread(new Consumer(middleMan),"消费者2").start();
//        new Thread(new Consumer(middleMan),"消费者3").start();

//        new Thread(new Producer(middleMan),"生产者1").start();
//        new Thread(new Producer(middleMan),"生产者2").start();
//        new Thread(new Producer(middleMan),"生产者3").start();
//        new Thread(new Producer(middleMan),"生产者4").start();
//        new Thread(new Producer(middleMan),"生产者5").start();




    }


}
