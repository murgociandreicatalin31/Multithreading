package ro.ctrln.java.sockets;

import java.io.IOException;

public class EasyServerUsage {

    public static void main(String[] args) throws IOException {

        EasyClient easyClient = new EasyClient();
        easyClient.connectToServer("localhost", 64645);
        String response = easyClient.sendMessageToServer("Salutare!");
        System.out.println("Raspunsul serverului a fost: " + response);
    }
}
