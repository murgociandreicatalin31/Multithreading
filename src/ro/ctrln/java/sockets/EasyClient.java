package ro.ctrln.java.sockets;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EasyClient {

    private Socket clientSocket;
    private PrintWriter writer;
    private BufferedReader reader;

    public void connectToServer(String hostname, int port) {
        try {
            clientSocket = new Socket(hostname, port);
            writer = new PrintWriter(clientSocket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public String sendMessageToServer(String message) throws IOException {
        writer.println(message);
        return reader.readLine();
    }
}
