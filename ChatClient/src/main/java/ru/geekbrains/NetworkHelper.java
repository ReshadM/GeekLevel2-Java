package ru.geekbrains;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class NetworkHelper {

    private final Socket socket;
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public NetworkHelper(String adress, int port, MessageService messageService) throws IOException {

        this.socket = new Socket(adress,port);
        this.inputStream = new DataInputStream(socket.getInputStream());
        this.outputStream = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            while (true) {
                try {
                    String msg = inputStream.readUTF();
                    messageService.receiveMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    public void writeMessage(String msg) {

        try {
            outputStream.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
