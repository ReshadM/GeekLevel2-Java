package ru.geekbrains;

import java.io.*;
import java.net.Socket;

public class ClientConsoleChat {

    private static final int SERVER_PORT = 65500;
    private static final String SERVER_HOST = "localhost";
    private static Socket socket;
    private static DataInputStream in;
    private static DataOutputStream out;
    private Thread clientConsoleThread;



    public static void main(String[] args) {
        (new ClientConsoleChat()).runClient();
    }

    private void runClient() {
        try {
            Socket socket = new Socket("localhost", 65500);

            try {
                System.out.println("Client is running");
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                this.startClientConsoleThread();

                while(true) {
                    String str = in.readUTF();
                    if (str.equals("/end")) {
                        this.shutdown();
                        break;
                    }

                    System.out.println("Retrieved message: " + str);
                }
            } catch (Throwable var10) {
                try {
                    socket.close();
                } catch (Throwable var9) {
                    var10.addSuppressed(var9);
                }

                throw var10;
            }

            socket.close();
        } catch (IOException var11) {
            var11.printStackTrace();
        } finally {
            System.out.println("From finally");
        }

    }

    private void shutdown() throws IOException {
        this.clientConsoleThread.interrupt();
        socket.close();
        System.out.println("Client is stopped!");
    }

    private void startClientConsoleThread() {
        this.clientConsoleThread = new Thread(() -> {
            BufferedReader clientInputStream = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("You can enter message to send to server:");

            while(!Thread.currentThread().isInterrupted()) {
                try {
                    if (clientInputStream.ready()) {
                        String messageFromClient = clientInputStream.readLine();
                        out.writeUTF(messageFromClient);
                        if (messageFromClient.equals("/end")) {
                            this.shutdown();
                            break;
                        }
                    }

                    Thread.sleep(500L);
                } catch (IOException | InterruptedException var3) {
                    break;
                }
            }

            System.out.println("Close System.in thread");
        });
        this.clientConsoleThread.start();
    }
}

