package com.company.interrupt;

import sun.plugin2.os.windows.FLASHWINFO;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/11/29 16:37
 * 有内鬼，中止交易
 */
public class MyInterruptDemo implements Runnable {

    private static volatile boolean FLAG = true;

    @Override
    public void run() {
        while (FLAG){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyInterruptDemo(),"标记位中止线程");
        thread.start();
        Thread.sleep(1000L);
        FLAG = false;
    }
}
