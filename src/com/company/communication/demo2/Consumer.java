package com.company.communication.demo2;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2020/1/16 18:29
 * 有内鬼，中止交易
 */
public class Consumer implements Runnable {

    private MiddleMan middleMan;

    public Consumer(MiddleMan middleMan){
        this.middleMan = middleMan;
    }

    @Override
    public void run() {
//        while (true){
            middleMan.take();
//        }
    }
}
