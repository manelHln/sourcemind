class Counter {
    int value = 1;
    void increment() {
        value++;
    }
}

public class ThreadRaceCondition {


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            test();
        }
    }

    private static void test() throws InterruptedException {
        Counter c = new Counter();

        Runnable task = () -> {
            c.increment();
        };

        for (int i = 0; i < 10; i++) {
            new Thread(task).start();
        }

        System.out.println("Final answer: " + c.value);
    }
}
