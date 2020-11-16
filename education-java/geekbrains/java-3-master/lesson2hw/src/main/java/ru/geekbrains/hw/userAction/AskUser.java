package ru.geekbrains.hw.userAction;

import java.util.Scanner;

public class AskUser {

    private static String[] message;

    public static String[] ask(){
        Scanner scanner = new Scanner(System.in);
        String msg;
        while(true){
            System.out.print("Pls enter your command here (for example /Товарыпоцене <от> <до>): ");
            msg = scanner.nextLine();
            if (isCorrectMsg(msg))
                break;
        }
        return message;
    }

    private static boolean isCorrectMsg(String msg){
        message = msg.toLowerCase().split("\\s");
        if (msg.isEmpty() && msg.length() < 2)
            return false;
        if (message[0].equals("/цена") && message.length == 2)
            return true;
        if (message[0].equals("/товарыпоцене") && message.length == 3)
            return true;
        if (message[0].equals("/сменитьцену") && message.length == 3)
            return true;
        return false;
    }
}
