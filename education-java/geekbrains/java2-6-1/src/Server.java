import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private ServerSocket socket;

    Server(){
        try {
            this.socket = new ServerSocket(4242);
            System.out.println("Server running on port: " + socket.getLocalPort());
            ClientHandler ch = new ClientHandler(this.socket.accept());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class ClientHandler{
        private Socket client;
        private BufferedReader br;
        private PrintWriter pw;
//        private Scanner scanner;
        private String msg;

        ClientHandler(Socket socket){
            this.client = socket;
//            this.scanner = new Scanner(System.in);
            try {
                this.br = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
                this.pw = new PrintWriter(client.getOutputStream());
                handler(this.client);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void handler(Socket socket) throws IOException {
            while(socket.isConnected()){
                msg = br.readLine();
                if (msg != null && !msg.isEmpty()){
                    System.out.println("#Server received a message from client: " + msg);
                    pw.print("echo: " + msg);
                    pw.flush();
                }
            }
        }
    }
}

