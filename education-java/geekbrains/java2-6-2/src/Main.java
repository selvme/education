import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        if (args.length != 1){
//            System.out.println("Не верно указаны данные для клиента \n(java -jar program.jar [localhost or 127.0.0.1] [2024])");
//            System.exit(1);
//        }
//        Client client = new Client(args[0], Integer.parseInt(args[1]));
        Client client = new Client("localhost", 4242);
        client.start();
    }
}

