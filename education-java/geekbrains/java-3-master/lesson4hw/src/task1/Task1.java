package task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class Task1 {

    public static void start() {
        Printer printer = new Printer();
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(new MyThread(printer, 'A'));
        service.execute(new MyThread(printer, 'B'));
        service.execute(new MyThread(printer, 'C'));
        service.shutdown();
    }
}
