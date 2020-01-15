package com.company.review1223;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/23 9:28
 * 有内鬼，中止交易
 */
public class SafeSingletonDemo2 {
    private static SafeSingletonDemo2 ourInstance = new SafeSingletonDemo2();

    public static SafeSingletonDemo2 getInstance() {
        return ourInstance;
    }

    private SafeSingletonDemo2() {
    }
}
