package org.example.web.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest0 {
    public static void main(String[] args) throws IOException {
        var socketServer = new ServerSocket(3_000);
        while (true) {
            Socket socket = socketServer.accept();
            var printStream = new PrintStream(socket.getOutputStream());
            printStream.println("Hello World");
            printStream.close();
            socket.close();
        }
    }
}
