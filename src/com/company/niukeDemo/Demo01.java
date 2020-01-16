package com.company.niukeDemo;

import java.util.Scanner;

/**
 * For:查询最后一个字符串的长度
 *
 * @Author: gemini
 * @Date: 2020/1/16 14:29
 * 有内鬼，中止交易
 */
public class Demo01 {
    public static Integer getLastWordLength(String str){
        if(str == null || str.length() > 5000){
            return null;
        }
        String[] strs = str.split(" ");
        String lastWord = strs[strs.length-1];
        return lastWord.length();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(getLastWordLength("hello world"));
    }
}
