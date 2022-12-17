package example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener extends Thread{
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            while (true){
                Socket socket = serverSocket.accept();


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
