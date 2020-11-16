package action;

import java.util.Scanner;

public class AskUser {

    public static int ask(){
        Scanner scanner = new Scanner(System.in);
        String msg = "";
        while(msg.isEmpty() || !msg.matches("\\d")){
            System.out.print("Enter are number of page for read: ");
            msg = scanner.nextLine();
        }
        return Integer.parseInt(msg);
    }
}

