package org.example.system;

import org.example.network.NetworkReaderModule;
import org.example.network.NetworkSenderModule;
import org.example.network.Request;
import org.example.network.Response;
import org.example.managers.CollectionManager;
import org.example.managers.CommandManager;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private DatagramChannel datagramChannel;
    private CollectionManager collectionManager;
    private NetworkReaderModule networkReaderModule;
    private NetworkSenderModule networkSenderModule;
    private ExecutorService executorService = Executors.newFixedThreadPool(10);
    private ByteBuffer buffer = ByteBuffer.allocate(500000);

    public Server(int port) throws IOException {
        datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);
        datagramChannel.bind(new InetSocketAddress(port));
        collectionManager = new CollectionManager();
        CollectionManager.setMap(CollectionManager.getDataBaseManager().getRoutes());
        new CommandManager();
        networkReaderModule = new NetworkReaderModule(datagramChannel);
        networkSenderModule = new NetworkSenderModule(datagramChannel);
    }

    public void start() {
        System.out.println("Сервер запущен");
        while (true) {
            try {
                InetSocketAddress clientAddress = (InetSocketAddress) datagramChannel.receive(buffer);
                if (buffer.position() > 0) { // Проверяем, есть ли данные в буфере
                    buffer.flip(); // Переворачиваем буфер для чтения
                    getRequest(clientAddress, buffer);
                }
            } catch (Exception ignored){

            }
        }
    }

    public void getRequest(InetSocketAddress clientAddress, ByteBuffer buffer) {
        new Thread(() -> {
            try {
                Request request = networkReaderModule.getRequest(buffer);
                execute(request, clientAddress);
                buffer.clear();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Ошибка чтения");
                // Обработка ошибки чтения
                System.out.println(e.getMessage());
            }
        }).start();
    }

    public void execute(Request request, InetSocketAddress clientAddress) throws IOException {
        executorService.execute(() -> {
            Response response = new Response();
            try {
                response.setMessage(CommandManager.startExecuting(request, collectionManager));
            } catch (Exception e) {
                response.setMessage("ERROR " + e.getMessage() + " " + e.getClass());
            }
            sendResponse(response, clientAddress);
        });
    }

    public void sendResponse(Response response, InetSocketAddress clientAddress) {
        new Thread(() -> {
            try {
                networkSenderModule.sendResponse(response, clientAddress);
            } catch (IOException e) {
                System.err.println("Ошибка отправки: " + e.getMessage());
            }
        }).start();
    }
}