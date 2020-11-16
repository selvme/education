package task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task2 {

    public static void start() {
        Writer writer = new Writer();
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(() -> {
            for (int i = 0; i < 10; i++) {
                writer.writeInFile(Thread.currentThread().getName());
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        service.shutdown();
    }
}
