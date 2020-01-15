package com.company.proxy;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/5 14:03
 * 有内鬼，中止交易
 */
public class TestProxy {

    public static void main(String[] args) {
        SellHouse medium = new Medium();
        medium.sell(4000.00);
    }


}
