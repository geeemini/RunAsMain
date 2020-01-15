package com.company.interrupt;

import javax.sound.midi.Soundbank;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/11/29 16:24
 * 有内鬼，中止交易
 */
public class UnsafeStop extends Thread {

    private static Integer i = 0;
    private static Integer j = 0;

    @Override
    public void run() {
        i++;
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j++;
    }

    public void printf(){
        System.out.println("i的值为 ====> "+i);
        System.out.println("j的值为 ====> "+j);
    }

    public static void main(String[] args) throws InterruptedException {
        UnsafeStop unsafeStop = new UnsafeStop();
        unsafeStop.start();
        Thread.sleep(1000L);
        unsafeStop.stop();
        unsafeStop.printf();
    }
}
