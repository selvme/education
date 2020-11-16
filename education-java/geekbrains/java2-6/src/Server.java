import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        Server server = new Server();
        server.start(4242);
    }

    void start(int port){
        ServerSocket serverSocket = null;
        Socket client = null;
        String line;
        try {
            serverSocket = new ServerSocket(port);
            client = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while(true){
                line = reader.readLine();
                if (line != null){
                    System.out.println(line);
                }else break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (client != null){
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
