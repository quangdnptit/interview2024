package com.example.demo.multithreading;

public class SimpleThread {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Running in a thread");
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        MyThread t = new MyThread();
//        t.start(); // NOT run()

        Thread tx = new Thread(new MyTask());
        System.out.println("init: " + tx.getState());
        tx.start();
        System.out.println("started: " + tx.getState());
        tx.sleep(10000);
        System.out.println("sleep: " + tx.getState());
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Running task");
        }
    }


}
