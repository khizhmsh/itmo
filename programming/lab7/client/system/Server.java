package org.example.system;

import org.example.network.Request;
import org.example.network.Response;

import java.io.*;
import java.net.*;

public class Server {

    private DatagramSocket socket;

    private InetSocketAddress socketAddress;
    private String host;
    private int port;

    private byte[] buffer = new byte[5000]; // Буфер для хранения входящих данных

    public Server(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
        socketAddress = new InetSocketAddress(host, port);
        socket = new DatagramSocket();
        socket.connect(socketAddress);
    }

    void reconnect() {
        try {
            socket = new DatagramSocket();
            socket.connect(socketAddress);
        } catch (SocketException e) {
            System.out.println("Something wrong with server");
        }
    }

    public void send(Request request) throws IOException, ClassNotFoundException, InterruptedException {
        // отправка пакета
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(request);
        objectOutputStream.close();
        DatagramPacket sendPacket = new DatagramPacket(byteArrayOutputStream.toByteArray(), byteArrayOutputStream.toByteArray().length, InetAddress.getByName(host), port);
        socket.send(sendPacket);
    }

    // прием пакета
    public DatagramPacket receiveResponse() throws IOException, InterruptedException {
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        for (int i = 0; i < 5; i++) {
            if (!socket.isConnected()) {
                reconnect();
                Thread.sleep(1000);
            } else break;
        }
        if (socket.isConnected()) {
            socket.receive(packet);
            // Обработка полученного ответа
            String receivedMessage = new String(packet.getData(), 0, packet.getLength());
            return packet;
        } else throw new IOException();
    }


    public Response getResponse() throws IOException, ClassNotFoundException {        // Извлечение данных из пакета
        try {
            DatagramPacket packet = receiveResponse();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packet.getData());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (Response) objectInputStream.readObject();
        } catch (IOException e) {
            System.out.println("Ошибка при получении пакета: " + e.getMessage());
            // Можно попробовать переподключиться к серверу
            reconnect();
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка десериализации: " + e.getMessage());
            // Можно попробовать переподключиться к серверу
            reconnect();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        throw new IOException("Не удалось получить ответ от сервера.");
    }


}