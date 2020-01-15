package com.company.interrupt;

/**
 * For:
 *
 * @Author: M.L.
 * @Date: 2019/11/29 15:37
 */
public class StopDemo implements Runnable {
    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName());
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopDemo());
        thread.start();
        Thread.sleep(2000L);
        thread.stop();
    }
}
