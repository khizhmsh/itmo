package org.example.system;

import org.example.db.DataBaseManager;
import org.example.network.NetworkReaderModule;
import org.example.network.NetworkSenderModule;
import org.example.network.Request;
import org.example.network.Response;
import org.example.exceptions.RootException;
import org.example.exceptions.WrongArgumentException;
import org.example.managers.CollectionManager;
import org.example.managers.CommandManager;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.*;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private DatagramChannel datagramChannel;
    private CollectionManager collectionManager;
    public static String data_path = "";
    private NetworkReaderModule networkReaderModule;
    private NetworkSenderModule networkSenderModule;
    private static DataBaseManager dataBaseManager;
    private ExecutorService executorService = Executors.newFixedThreadPool(10); // Fixed thread pool for request processing

    public Server(int port, String path, DataBaseManager dataBaseManager) throws IOException, WrongArgumentException, ParserConfigurationException, RootException, SAXException {
        data_path = path;
        datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);
        datagramChannel.bind(new InetSocketAddress(port));
        collectionManager = new CollectionManager();

        collectionManager.setMap(dataBaseManager.getRoutes());
        new CommandManager();

        networkReaderModule = new NetworkReaderModule(datagramChannel);
        networkSenderModule = new NetworkSenderModule(datagramChannel);
    }

    public void listen() {
        System.out.println("Сервер запущен");
        while (true) {
            try {
                // Чтение запроса в отдельном потоке
                new Thread(() -> {
                    try {
                        Request request = networkReaderModule.getRequest();
                        InetSocketAddress clientAddress = networkReaderModule.getClientAddress();
                        // Обработка запроса в пуле потоков
                        executorService.execute(() -> {
                            Response response = execute(request);
                            // Отправка ответа в отдельном потоке
                            new Thread(() -> {
                                try {
                                    networkSenderModule.sendResponse(response, clientAddress);
                                } catch (IOException e) {
                                    // Обработка ошибки отправки
                                    System.err.println("Ошибка отправки ответа: " + e.getMessage());
                                }
                            }).start();
                        });
                    } catch (IOException | ClassNotFoundException e) {
                        // Обработка ошибки чтения
                        // System.err.println("Ошибка чтения запроса: " + e.getMessage());
                    }
                }).start();
            } catch (Exception e) {
                // Обработка общей ошибки
                System.err.println("Ошибка сервера: " + e.getMessage());
            }
        }
    }

    public Response execute(Request request) {
        Response response = new Response();
        try {
            response.setMessage(CommandManager.startExecuting(request, collectionManager));
            return response;
        } catch (Exception e) {
            response.setMessage("ERROR " + e.getMessage() + " " + e.getClass());
            return response;
        }
    }


    public void close() throws IOException {
        datagramChannel.close();
    }

    public static DataBaseManager getDataBaseManager() {
        return dataBaseManager;
    }

    public static void setDataBaseManager(DataBaseManager dbManager) {
        dataBaseManager = dbManager;
    }
}