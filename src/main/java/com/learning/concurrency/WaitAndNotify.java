package com.learning.concurrency;

public class WaitAndNotify {

    private static final Object LOCK = new Object();
    public static void main(String[] args) {

        Thread one = new Thread(() -> {
            try {
                one();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread two = new Thread(() -> {
            try {
                two();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        one.start();
        two.start();
    }
    private static void one() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("In method one...");
            LOCK.wait();
            System.out.println("back again in the method one");
        }
    }
    private static void two() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("In method two...");
            LOCK.notify();
            System.out.println("method two after notify");
        }
    }
}
