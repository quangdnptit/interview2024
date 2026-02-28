package com.example.demo.Java8;

public class FunctionalInterfaceDemo {
    @FunctionalInterface
    interface MyFunc {
        void run();
    }

    public void execute(MyFunc func) {
        func.run();
    }

    public static void main(String[] args) {
        FunctionalInterfaceDemo functionalInterfaceDemo = new FunctionalInterfaceDemo();
        functionalInterfaceDemo.execute(() -> System.out.println("wadu heck"));
    }
}
