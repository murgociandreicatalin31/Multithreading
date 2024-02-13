package ro.ctrln.java.sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EasyServer {

    public static void main(String[] args) {

        EasyServer easyServer = new EasyServer();
        easyServer.start(64645);
    }

    private void start(int port) {
        try(ServerSocket serverSocket = new ServerSocket(port);
            Socket socketClient = serverSocket.accept();
            PrintWriter printWriter = new PrintWriter(socketClient.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()))) {

            String message = reader.readLine();
            if("Salut EasyServer!".equalsIgnoreCase(message)) {
                printWriter.println("Salut Clientule!");
            } else {
                printWriter.println("Nu te cunosc!");
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
