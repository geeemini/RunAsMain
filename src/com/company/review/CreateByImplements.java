package com.company.review;

import javax.sound.midi.Soundbank;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/2 9:51
 * 有内鬼，中止交易
 */
public class CreateByImplements implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new CreateByImplements());
        thread.setName("asda");
        thread.start();

    }
}
