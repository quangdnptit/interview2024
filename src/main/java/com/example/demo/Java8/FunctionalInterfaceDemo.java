package com.example.demo.Java8;

import java.util.List;

public class FunctionalInterfaceDemo {
    @FunctionalInterface
    interface MyFunc {
        void run();
    }

    public void execute(MyFunc func) {
        func.run();
    }

    interface Addable<T> {
        T add(T a, T b);
    }

    public static void main(String[] args) {
        FunctionalInterfaceDemo functionalInterfaceDemo = new FunctionalInterfaceDemo();
        functionalInterfaceDemo.execute(() -> System.out.println("wadu heck"));

        Addable<Integer> addable = (a, b) -> {return a + b;};
        int result = addable.add(1, 2);
        System.out.println(result);

        List<Integer> inits = List.of(1, 2, 3, 4 ,5);
        System.out.println(inits.stream().count());
    }
}
