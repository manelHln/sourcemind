public class ExampleThread {
    public static void main(String[] args) throws InterruptedException {
        Thread aThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        });
        aThread.setDaemon(true);
        aThread.start();
        aThread.join();

        System.out.println("Continue with main");
    }
}
