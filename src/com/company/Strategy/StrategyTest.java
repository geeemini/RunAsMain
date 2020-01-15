package com.company.Strategy;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/5 14:43
 * 有内鬼，中止交易
 */
public class StrategyTest {

    public static void main(String[] args) {
        Person chinese = new Chinese();
        Person african = new African();
        Person american = new American();

        chinese.repast();
        african.repast();
        american.repast();


    }



}
