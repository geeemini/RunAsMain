package com.company.review;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2019/12/2 9:45
 * 有内鬼，中止交易
 */
public class CreateThreadByExtendThreadReview extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        CreateThreadByExtendThreadReview extendThreadReview = new CreateThreadByExtendThreadReview();
        extendThreadReview.setName("aaa");
        extendThreadReview.start();
    }
}
