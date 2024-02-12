package org.example.visibility;

public class VisibilityProblem {
    static boolean ready = false;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 started");
            while (!ready);
            System.out.println("Thread 1 complete");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 started");
            ready = true;
            System.out.println("Thread 2 complete");
        });

        thread1.start();
        Thread.sleep(1000);
        thread2.start();
    }
}
