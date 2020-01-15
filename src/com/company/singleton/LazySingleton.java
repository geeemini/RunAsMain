package com.company.singleton;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/9 13:56
 * 有内鬼，中止交易
 */
public class LazySingleton {
    private static volatile LazySingleton ourInstance = null;

    public static LazySingleton getInstance() {
        if(ourInstance == null){
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (LazySingleton.class){
                if(ourInstance == null){
                    ourInstance = new LazySingleton();
                }
            }
        }
        return ourInstance;
    }

    private LazySingleton() {
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(LazySingleton.getInstance());
            }).start();
        }
    }
}
