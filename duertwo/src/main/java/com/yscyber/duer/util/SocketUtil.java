package com.yscyber.duer.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 */
public final class SocketUtil {

    private ServerSocket serverSocket;
    private Socket socket;
    private PrintWriter printWriter;

    private static final int PORT = 65533;

    public void connection() {
        try {
            serverSocket = new ServerSocket(PORT);
            // can block until get connection
            socket = serverSocket.accept();
            printWriter = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String code) {
        printWriter.println(code);
        printWriter.flush();
    }

    public void disConnection() {
        if (printWriter != null) {
            printWriter.close();
            printWriter = null;
        }
        try {
            if (socket != null) {
                socket.close();
                socket = null;
            }
            if (serverSocket != null) {
                serverSocket.close();
                serverSocket = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}