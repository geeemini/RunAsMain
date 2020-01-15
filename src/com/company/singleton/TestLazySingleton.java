package com.company.singleton;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/9 14:55
 * 有内鬼，中止交易
 */
public class TestLazySingleton {

    private static volatile TestLazySingleton lazySingleton = null;

    public static TestLazySingleton getLazySingleton(){
        if(lazySingleton == null){
            synchronized (TestLazySingleton.class){
                if(lazySingleton == null){
                    lazySingleton = new TestLazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    private TestLazySingleton(){}

}
