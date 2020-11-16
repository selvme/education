import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

final class Client {
    private Socket socket;
    private Scanner scanner;
    private BufferedReader br;
    private PrintWriter pw;
    private final String STOP = "STOP";

    Client(String host, int port){
        this.scanner = new Scanner(System.in);
        try {
            this.socket = new Socket(host, port);
            this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.pw = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void start(){
        System.out.println("Client starting...");
        receiveFromServer();
        receiveFromUser();
        System.out.println("Client running...");
    }

    private void receiveFromUser(){
        Thread user = new Thread(()->{
            while(socket.isConnected()){
                System.out.print("$Client: ");
                String msg = scanner.nextLine();
                if (msg.toUpperCase().equals(STOP))
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                sendMessageToServer(msg);
            }
        }, "FromUser");
        user.start();
    }

    private void receiveFromServer(){
        Thread server = new Thread(()->{
            while(socket.isConnected()){
                String msg = null;
                try {
                    msg = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                consolePrint(msg);
            }
        }, "FromServer");
        server.start();
    }

    private void consolePrint(String message){
        if (message != null && !message.isEmpty())
            System.out.println(message);
    }

    private void sendMessageToServer(String message){
        System.out.println("Send msg...");
        pw.print(message);
        pw.flush();
    }
}

