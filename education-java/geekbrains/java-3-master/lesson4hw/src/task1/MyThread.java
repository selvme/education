package task1;

class MyThread implements Runnable{
    private Printer printer;
    private char c;

    MyThread(Printer printer, char c){
        this.printer = printer;
        this.c = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            printer.print(c);
        }
    }
}
