package org.example.web.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketClientTest0 {
    public static void main(String[] args) throws IOException {
        var socket = new Socket("127.0.0.1", 3_000);
        var bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = bufferReader.readLine();
        System.out.println(line);
        bufferReader.close();
        socket.close();
    }
}
