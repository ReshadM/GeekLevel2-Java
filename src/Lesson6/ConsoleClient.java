package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleClient {

    private static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        try (Socket socket  = new Socket("localhost", 65500)) {

            System.out.println("Server started");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true) {

                String msg = SCANNER.nextLine();
                out.writeUTF(msg);
                Thread.sleep(200);
                msg = in.readUTF();
                System.out.println("Received: " + msg);

            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
