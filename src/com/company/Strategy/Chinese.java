package com.company.Strategy;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/5 14:40
 * 有内鬼，中止交易
 */
public class Chinese implements Person {
    @Override
    public void repast() {
        System.out.println("中国人用筷子恰饭");
    }
}
