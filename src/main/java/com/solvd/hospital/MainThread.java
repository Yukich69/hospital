package com.solvd.hospital;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThread {
    public static void main(String[] args){
        ExecutorService es = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 2; i++) {
            es.execute(new MyThread(new Date()));
            es.execute(new MyThread(new Date(102, 3, 20)));
        }
        es.shutdown();
    }
}

class MyThread extends Thread {
    Date date;

    public MyThread(Date date) {
        this.date = date;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println(date);
        }
    }
}
