package com.company;

public class MyWaitNotify {

    MyThread myThread = new MyThread();
    boolean signed = false;

    public void dowait(){
        synchronized (myThread){
            while (!signed){
                try {
                    myThread.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            signed = true;
        }
    }

    public void doNotify(){
        myThread.notify();
       /* synchronized (myThread){
            signed = false;
            myThread.notify();
        }*/
    }


}
