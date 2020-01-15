package com.company.synchroized;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/3 18:14
 * 有内鬼，中止交易
 */
public class KonwSynchroizedDemo {

    //锁住普通方法
    /*public void cout(){
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    //锁住静态方法
    /*public static synchronized void cout(){
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    //锁住代码块中的对象
    private Object obj = new Object();
    public void cout(){
        synchronized (obj){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {
        KonwSynchroizedDemo konwSynchroizedDemo = new KonwSynchroizedDemo();
        new Thread(()->{
            konwSynchroizedDemo.cout();
        }).start();

        new Thread(()->{
            konwSynchroizedDemo.cout();
        }).start();
    }

}
