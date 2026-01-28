package com.example.demo.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureDemo {

    static ExecutorService pool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        CompletableFuture<String> userFuture =
                CompletableFuture.supplyAsync(() -> {
                    log("Fetching USER...");
                    sleep(2000);
                    return "User-Q";
                }, pool);

        CompletableFuture<String> orderFuture =
                CompletableFuture.supplyAsync(() -> {
                    log("Fetching ORDER...");
                    sleep(1000);
                    return "Order-123";
                }, pool);

        CompletableFuture<String> result =
                userFuture.thenCombine(orderFuture, (user, order) -> {
                    log("Combining result");
                    return user + " | " + order;
                });

        log("Main thread is FREE");

        String finalResult = result.join(); // wait here
        log("Final result = " + finalResult);

        pool.shutdown();
        log("Total time = " + (System.currentTimeMillis() - start) + "ms");
    }

    static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (Exception ignored) {}
    }

    static void log(String msg) {
        System.out.println(Thread.currentThread().getName() + " | " + msg);
    }
}
