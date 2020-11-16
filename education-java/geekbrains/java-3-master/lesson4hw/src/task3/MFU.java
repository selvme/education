package task3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MFU implements AutoCloseable {

    private final Object scanLock;
    private final Object printLock;

    private AtomicInteger countScanDoc;
    private AtomicInteger countPrintDoc;
    private ScheduledExecutorService service;

    MFU() {
        scanLock = new Object();
        printLock = new Object();
        countScanDoc = new AtomicInteger(1);
        countPrintDoc = new AtomicInteger(1);
        service = Executors.newSingleThreadScheduledExecutor();
    }

    void scanDoc(String doc) {
        synchronized (scanLock) {
            service.schedule(() -> {
                System.out.printf("%s Scanning the document #%d...\n", doc, countScanDoc.getAndIncrement());
            }, 50, TimeUnit.MILLISECONDS);
        }
    }

    void printDoc(String doc) {
        synchronized (printLock) {
            service.schedule(() -> {
                System.out.printf("%s Printing the document #%d...\n", doc, countPrintDoc.getAndIncrement());
            }, 50, TimeUnit.MILLISECONDS);
        }
    }

    @Override
    public void close() {
        this.service.shutdown();
    }
}
