package org.example.deadlock;

public class DeadlockProblem {
    public static void main(String[] args) {
        var program = new DeadlockProblem();

        Thread threadA = new Thread(program::methodA, "Thread A");
        Thread threadB = new Thread(program::methodB, "Thread B");

        threadA.start();
        threadB.start();
    }

    Object lock1 = new Object();
    Object lock2 = new Object();

    void methodA() {
        synchronized (lock1) {
            System.out.println("method a started");
            methodB();
            System.out.println("method a finished");
        }
    }

    void methodB() {
        synchronized (lock2) {
            System.out.println("method b started");
            synchronized (lock1) {
                System.out.println("processing in method b");
            }
            System.out.println("method b finished");
        }
    }
}
