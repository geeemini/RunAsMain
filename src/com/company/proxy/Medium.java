package com.company.proxy;

import javax.sound.midi.Soundbank;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/5 14:01
 * 有内鬼，中止交易
 */
public class Medium implements SellHouse {

    SellHouse house = new Hoster();

    @Override
    public void sell(Double money) {
        if(money >= 1000){
            house.sell(money);
        }else {
            System.out.println("你的价钱太低了");
        }
    }
}
