package com.example.demo.multithreading;

public class VolatileKeyWord {
    volatile static boolean stop = false;

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(() -> {
            long count = 0;
            while (!stop) {
                count++;
            }
            System.out.println("Stopped at count=" + count);
        });

        t.start();

        Thread.sleep(100);
        //set stop = true in the main thread but the program keep running because the new thread doesn't see the updated val,
        // can fix with volatile keyword
        stop = true;
        System.out.println("Main set stop=true");
    }
}
