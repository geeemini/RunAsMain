package com.company.Strategy;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/5 14:42
 * 有内鬼，中止交易
 */
public class American implements Person {
    @Override
    public void repast() {
        System.err.println("美国人不吃饭");
    }
}
