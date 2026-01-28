package com.example.demo.multithreading;

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService pool =  new ThreadPoolExecutor(
                2,                      // core threads
                4,                      // max threads
                10, TimeUnit.SECONDS,   // idle timeout
                new ArrayBlockingQueue<>(2), // bounded queue
                new ThreadPoolExecutor.CallerRunsPolicy() // reject policy
        );

        for (int i = 1; i <= 15; i++) {
            int taskId = i;
            pool.submit(() -> {
                System.out.println(
                        Thread.currentThread().getName() + " running task " + taskId
                );
                sleep(1000);
            });
        }

        pool.shutdown();
    }

    static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}

