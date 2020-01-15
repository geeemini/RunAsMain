package com.company.review1223;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/23 9:26
 * 有内鬼，中止交易
 */
public class SafeSingletonDemo {

    private static SafeSingletonDemo singletonDemo = null;

    private SafeSingletonDemo(){

    }

    public SafeSingletonDemo getInstance() {

        if(singletonDemo == null){
            //假设初始化的时候时间比较长
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (SafeSingletonDemo.class){
                if(singletonDemo == null)
                    singletonDemo = new SafeSingletonDemo();
            }

        }

        return singletonDemo;
    }

    public static void main(String[] args) {
        SafeSingletonDemo demo = new SafeSingletonDemo();
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+":"+demo.getInstance());
            }).start();
        }

    }
}
