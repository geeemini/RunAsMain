package com.company;

public class DeadLockDemo {

    private static final Object OBJECT_A = new Object();
    private static final Object OBJECT_B = new Object();

    public static void main(String[] args) {

        new Thread(()->{
            synchronized (OBJECT_A){
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (OBJECT_B){
                    System.out.println("a成功揪住了b的头发");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (OBJECT_B){
                synchronized (OBJECT_A){
                    System.out.println("b成功揪住了a的头发");
                }
            }
        }).start();


    }


}
