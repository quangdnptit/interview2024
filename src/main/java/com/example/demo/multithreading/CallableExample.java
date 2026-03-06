package com.example.demo.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableExample {
    public static void main(String[] args) {
        // 1. Define the task using Callable
        Callable<Long> factorialTask = () -> {
            int number = 10;
            System.out.println("Calculating factorial for: " + number);
            TimeUnit.SECONDS.sleep(1); // Simulating heavy work

            long result = 1;
            for (int i = 1; i <= number; i++) {
                result *= i;
            }
            return result;
        };

        // 2. Submit to an ExecutorService
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            System.out.println("Submitting task...");
            Future<Long> future = executor.submit(factorialTask);

            // 3. Do other things while the calculation happens
            System.out.println("Main thread is free to do other work...");

            // 4. Retrieve the result (This blocks until finished)
            Long finalResult = future.get();
            System.out.println("Result received: " + finalResult);

        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Task failed: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}