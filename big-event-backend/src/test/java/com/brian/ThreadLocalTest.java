package com.brian;

import org.junit.jupiter.api.Test;


public class ThreadLocalTest {
    @Test
    public void testThreadLocalSetGet() {
        ThreadLocal tl = new ThreadLocal<>();

        new Thread(() -> {
            tl.set("brian");
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
        },"blue").start();

        new Thread(() -> {
            tl.set("joyce");
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
        },"red").start();
    }
}
