package org.example.system;


import org.example.db.DataBaseManager;
import org.example.managers.CollectionManager;
import org.example.managers.Receiver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        try {
            Configurator configurator = new Configurator(args[0]);
            DataBaseManager dataBaseManager = new DataBaseManager(configurator.getLink(), configurator.getUser(), configurator.getPassword());
            CollectionManager.setDataBaseManager(dataBaseManager);

            System.out.println("serer settings " + configurator.getPort());
            Server server = new Server(configurator.getPort());
            server.start();
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