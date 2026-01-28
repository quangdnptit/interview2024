package com.example.demo.multithreading;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.example.demo.multithreading.CompletableFutureDemo.log;

public class AllOfResult {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        CompletableFuture<String> f1 = supply("User", 1000);
        CompletableFuture<String> f2 = supply("Order", 1500);
        CompletableFuture<String> f3 = supply("Payment", 1200);
        CompletableFuture<String> f0 = CompletableFuture.supplyAsync(() -> {
            log("doan xem - wtf ");
            if (true) {
                throw new RuntimeException("Fail");
            }
            return "doan xem";
        }).exceptionally(ex -> "mock exception");

        CompletableFuture<Void> all =
                CompletableFuture.allOf(f1, f2, f3, f0);

        List<String> results = all.thenApply(v ->
                List.of(f1.join(), f2.join(), f3.join())
        ).join();

        log(f0.join());

        log("Total time = " + (System.currentTimeMillis() - start) + "ms");
        System.out.println("Results = " + results);
    }

    static CompletableFuture<String> supply(String name, int ms) {
        return CompletableFuture.supplyAsync(() -> {
            log("wtf -- " + name);
            sleep(ms);
            return name;
        });
    }

    static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (Exception ignored) {}
    }
}
