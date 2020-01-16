package com.company.communication.demo2;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2020/1/16 18:28
 * 有内鬼，中止交易
 */
public class Producer implements Runnable {
    private MiddleMan middleMan;

    public Producer(MiddleMan middleMan){
        this.middleMan = middleMan;
    }

    @Override
    public void run() {
//        while (true){
            middleMan.put();
//        }
    }
}
