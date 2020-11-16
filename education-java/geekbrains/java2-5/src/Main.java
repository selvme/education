/**
 *
 * @author Alexandr Yudin
 * @version 1.0
 */
import java.util.Arrays;

public class Main implements Runnable {

    final int size = 10000000;
    final int h = size / 2;
    float[] arr = new float[size];
    float[] thAr1 = new float[h];
    float[] thAr2 = new float[h];

    public static void main(String[] args) {
        Main hw = new Main();
        System.out.println(hw.ClassLoader());
        hw.withoutThreads();
        hw.withThreads();
    }

    void withoutThreads() {
        Arrays.fill(arr, 1);
        long st = System.currentTimeMillis();
        for (int i = 0; i < size; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("1 способ " + (System.currentTimeMillis() - st));
    }

    void withThreads() {
        Arrays.fill(arr, 1);
        long st = System.currentTimeMillis();
        System.arraycopy(arr, 0, thAr1, 0, h);
        System.arraycopy(arr, h, thAr2, 0, h);
        Thread one = new Thread(this, "One");
        Thread two = new Thread(this, "Two");
        one.start();
        two.start();
        try {
            one.join();
            two.join();
        } catch (InterruptedException ex) { } // waiting
        System.arraycopy(thAr1, 0, arr, 0, h);
        System.arraycopy(thAr2, 0, arr, h, h);
        System.out.println("2 способ " + (System.currentTimeMillis() - st));
    }
    
    public void run() {
        for (int i = 0; i < h; i++)
            if (Thread.currentThread().getName().toLowerCase() == "one")
                thAr1[i] = (float)(thAr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            else
                thAr2[i] = (float)(thAr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }
}