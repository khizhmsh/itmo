package org.example.system;

import org.example.network.Request;
import org.example.network.Response;

import java.io.*;
import java.net.*;

public class Server {

    private DatagramSocket socket;

    private InetSocketAddress socketAddress;

    private byte[] buffer = new byte[5000]; // Буфер для хранения входящих данных

    public Server(String host, int port) throws IOException {
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
        DatagramPacket sendPacket = new DatagramPacket(byteArrayOutputStream.toByteArray(), byteArrayOutputStream.toByteArray().length, InetAddress.getByName("localhost"), 4356);
        socket.send(sendPacket);
    }

    // прием пакета
    public DatagramPacket receiveResponse() throws IOException {
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        return packet;
    }

    public Response getResponse() throws IOException, ClassNotFoundException {        // Извлечение данных из пакета
        DatagramPacket packet = receiveResponse();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packet.getData());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Response response = (Response) objectInputStream.readObject();
        return response;

    }

}