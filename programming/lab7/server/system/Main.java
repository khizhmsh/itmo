package org.example.system;


import org.example.db.DataBaseManager;
import org.example.managers.Receiver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.util.Properties;

public class Main {
    public static final String DATABASE_URL = "jdbc:postgresql://localhost:1567/studs";
    public static final String DATABASE_URL_HELIOS = "jdbc:postgresql://pg:5432/studs";

    public static void main(String[] args) {
        try {
            Properties info = new Properties();
            info.load(new FileInputStream(args[2]));
            DataBaseManager dataBaseManager = new DataBaseManager(DATABASE_URL, info.getProperty("user"), info.getProperty("password"));
            Server.setDataBaseManager(dataBaseManager);

            // Получить значение переменной окружения "server"
            String serverSettings = System.getenv("server");
            // Проверить, существует ли переменная
            if (serverSettings != null && serverSettings.split(" ").length == 2) {
                System.out.println("serer settings " + serverSettings);
            } else {
                System.out.println("Переменная окружения server не найдена.");
                System.exit(1);
            }

            int port = Integer.parseInt(serverSettings.split(" ")[0]);
            String path = serverSettings.split(" ")[1];
            Server server = new Server(port, path, dataBaseManager);
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