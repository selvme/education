import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class Client implements Runnable{

    private final String ADDRESS;
    private final int PORT;

    Client(String address, int port){
        this.ADDRESS = address;
        this.PORT = port;
    }

    private void start(String address, int port){
        try {
            Socket socket = new Socket(address, port);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = br.readLine();
            System.out.println(line != null ? "Ваш совет на день: " + line : "К сожалению мне нечего Вам посоветовать");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.start(this.ADDRESS, this.PORT);
    }
}
