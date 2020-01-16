package com.company.communication.demo2;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2020/1/16 18:29
 * 有内鬼，中止交易
 */
public class MiddleMan {
    private volatile int  i ;
    private static final int MAX = 20;

    /**
     * 生产者生产
     */
    public synchronized void put(){
        //如果当前数量大于最大数量，则暂停生产
        //如果当前数量小于最大数量，则生产，通知消费者消费
        if(i < MAX){
            System.out.println("生产者"+Thread.currentThread().getName()+"生产 ======》当前数量为："+ ++i);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifyAll();
        }else {
            try {
                System.out.println("生产者"+Thread.currentThread().getName()+"生产 ======》数量已满："+ i);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

     /**
     * 消费者消费
     */
    public synchronized void take(){
        //如果当前数量小于0  暂停消费
        //如果正常   通知生产者生产
        if(i > 0){
                System.out.println("消费者"+Thread.currentThread().getName()+"消费 =====>"+ --i);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifyAll();
        }else {
            try {
                System.out.println("消费者"+Thread.currentThread().getName()+"消费 =====>但是没库存"+ i);
                wait();
                System.out.println(Thread.currentThread().getName()+"wait结束"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
