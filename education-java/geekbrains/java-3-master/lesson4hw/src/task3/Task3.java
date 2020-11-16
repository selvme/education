package task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task3 {

    public static void start() {
        try (MFU mfu = new MFU()) {
            ExecutorService service = Executors.newFixedThreadPool(4);
            service.submit(() -> {
                for (int i = 0; i < 5; i++) {
                    mfu.printDoc(Thread.currentThread().getName());
                }
            });
            service.submit(() -> {
                for (int i = 0; i < 5; i++) {
                    mfu.printDoc(Thread.currentThread().getName());
                }
            });
            service.submit(() -> {
                for (int i = 0; i < 5; i++) {
                    mfu.scanDoc(Thread.currentThread().getName());
                }
            });
            service.submit(() -> {
                for (int i = 0; i < 5; i++) {
                    mfu.scanDoc(Thread.currentThread().getName());
                }
            });
            service.shutdown();
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
