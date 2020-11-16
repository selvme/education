public class Main {

    public static void main(String[] args) {
        final String IP_ADDRESS = "localhost";
        final int PORT = 4242;
        String[] adv = {
                "Совет №1",
                "Совет №2",
                "Совет №3",
                "Совет №4",
                "Совет №5",
                "Совет №6",
                "Совет №7",
                "Совет №8",
                "Совет №9",
                "Совет №10",
        };

        Server server = new Server(PORT, adv);
        Client client = new Client(IP_ADDRESS, PORT);

        Thread serverThread = new Thread(server);
        Thread clientThread = new Thread(client);
        serverThread.start();
        clientThread.start();
        try {
            serverThread.join();
            clientThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        serverThread.stop();
        clientThread.stop();
    }


}
