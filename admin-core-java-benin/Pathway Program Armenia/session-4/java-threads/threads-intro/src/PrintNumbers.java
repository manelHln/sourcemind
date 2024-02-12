public class PrintNumbers {
    public static void main(String[] args) {

        Runnable task = () -> {
            for (int i = 0; i < 100; ++i) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        };

        Thread t1 = new Thread(task);
        t1.setName("Thread-1");

        Thread t2 = new Thread(task);
        t2.setName("Thread-2");

        t1.start();
        t2.start();
    }
}
