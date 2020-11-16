import action.AskUser;
import model.FStask1;
import model.FStask2;
import model.FStask3;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        FStask1 fStask1 = new FStask1(".\\resources\\test.txt");
        fStask1.readToConsole();

        FStask2 fStask2 = new FStask2();
        fStask2.addFile(".\\resources\\task2-1.txt");
        fStask2.addFile(".\\resources\\task2-2.txt");
        fStask2.addFile(".\\resources\\task2-3.txt");
        fStask2.addFile(".\\resources\\task2-4.txt");
        fStask2.addFile(".\\resources\\task2-5.txt");
        try {
            fStask2.mergeFiles(".\\resources\\task2result.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        FStask3 fStask3 = new FStask3(".\\resources\\book.txt");
        System.out.println(fStask3.readPage(AskUser.ask()));
    }
}
