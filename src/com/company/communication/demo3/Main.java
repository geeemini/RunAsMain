package com.company.communication.demo3;

import java.io.*;

/**
 * For:
 *
 * @Author: gemini
 * @Date: 2020/1/16 19:17
 * 有内鬼，中止交易
 */
public class Main {
    public static void main(String[] args) throws IOException {
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();

        pipedOutputStream.connect(pipedInputStream);

        new Thread(new Reader(pipedInputStream)).start();

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            pipedOutputStream.write(bufferedReader.readLine().getBytes());
        }finally {
            pipedOutputStream.close();
            if (bufferedReader != null){
                bufferedReader.close();
            }
        }


    }



}
