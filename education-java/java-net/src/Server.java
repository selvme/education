import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
    private ServerSocket serverSocket = null;
    private Socket client = null;
    private final int PORT;
    private final String[] ADV_LIST;

    Server(int port, String[] adv){
        this.PORT = port;
        this.ADV_LIST = adv;
    }

    void start(){
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Текущий открытый порт на сервере: " + serverSocket.getLocalPort());
            while(true){
                client = serverSocket.accept();
                PrintWriter writer = new PrintWriter(client.getOutputStream());
                writer.println(getAdv());
                writer.flush();
                writer.close();
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String getAdv(){
        int random = (int)(Math.random() * ADV_LIST.length);
        return ADV_LIST[random];
    }

    @Override
    public void run() {
        this.start();
    }
}
