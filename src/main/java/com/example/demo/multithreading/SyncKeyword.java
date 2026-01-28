package com.example.demo.multithreading;

public class SyncKeyword {


    static int count = 0;

     static class Worker extends Thread {
        @Override
        public synchronized void run() {
            for (int i = 0; i < 1_000_000; i++) {
                count++; // NOT atomic
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Worker worker = new Worker();

        Thread t1 = new Thread(worker);
        Thread t2 = new Thread(worker);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count = " + count);
    }

}
