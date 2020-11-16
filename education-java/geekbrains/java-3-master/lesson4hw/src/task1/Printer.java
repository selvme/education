package task1;

class Printer {
    private final char[] CHARS = {'A', 'B', 'C'};
    private int nextChar;

    synchronized void print(char c){
        while (c != CHARS[nextChar]){
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("ERR: thread was interrupted in print method!");
                e.printStackTrace();
            }
        }
        System.out.print(c);
        if (nextChar >= 2){
            nextChar = 0;
        }else {
            nextChar++;
        }
        notifyAll();
    }
}
