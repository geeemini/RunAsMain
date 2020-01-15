package com.company.singleton;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/9 13:56
 * 有内鬼，中止交易
 */
public class HungrySingleton {
    private static HungrySingleton ourInstance = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return ourInstance;
    }

    private HungrySingleton() {
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(HungrySingleton.getInstance());
            }).start();
        }

    }

}
