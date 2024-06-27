package com.example.demo.interview;

public class Singleton  {
    private volatile static Singleton instance;

    // Private constructor to avoid client applications to use constructor
    private Singleton() {
    }

    public synchronized static Singleton getInstance() {
        if (instance == null) {
            // Block so other threads cannot come into while initialize
            synchronized (Singleton.class) {
                // Re-check again. Maybe another thread has initialized before
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
