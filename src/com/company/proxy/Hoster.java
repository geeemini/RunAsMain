package com.company.proxy;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/5 14:01
 * 有内鬼，中止交易
 */
public class Hoster implements SellHouse {
    @Override
    public void sell(Double money) {
        System.out.println("祝你住的愉快");
    }
}
