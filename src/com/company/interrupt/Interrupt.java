package com.company.interrupt;

import javax.sound.midi.Soundbank;
import java.util.TreeMap;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/11/29 16:31
 * 有内鬼，中止交易
 */
public class Interrupt implements Runnable {

    private static Object obj = new Object();

    @Override
    public void run() {
        synchronized (obj){
            while (!Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName());
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Interrupt());
        thread1.start();
        Thread.sleep(2000L);
        thread1.interrupt();

        Thread thread2 = new Thread(new Interrupt());
        thread2.start();

    }
}
