package org.example.system;


import org.example.managers.Receiver;

import java.io.IOException;
import java.net.SocketException;

public class Main {
    public static void main(String[] args) {

        // Получить значение переменной окружения "server"
        String serverSettings = System.getenv("server");
        // Проверить, существует ли переменная
        if (serverSettings != null && serverSettings.split(" ").length == 2) {
            System.out.println("serer settings " + serverSettings);
        } else {
            System.out.println("Переменная окружения server не найдена.");
            System.exit(1);
        }


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Действия, которые нужно выполнить перед завершением работы
            System.out.println("Stop working...");
            try {
                Receiver.saveFile();
            } catch (Exception e) {
                System.out.println("Something wrong with File");
            }
        }));


        try {
            int port = Integer.parseInt(serverSettings.split(" ")[0]);
            String path = serverSettings.split(" ")[1];
            Server server = new Server(port, path);
            server.listen();
        } catch (SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Something wrong");
            System.exit(1);
        } finally {
            System.out.println("Something wrong");
            System.exit(1);
        }
    }
}