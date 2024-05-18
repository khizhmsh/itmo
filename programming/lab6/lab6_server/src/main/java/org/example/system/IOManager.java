package org.example.system;

import org.example.network.Request;
import org.example.network.Response;

import java.io.*;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class IOManager {
    public static Request getRequest(ByteBuffer buffer, InetSocketAddress clientAddress) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer.array());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Request request = (Request) objectInputStream.readObject();
        System.out.println("Получено сообщение от " + clientAddress + ": " + request.getNameCommand() + " " + request.getArgs());
        return request;
    }

    public static void sendResponse(Response response, InetSocketAddress clientAddress, DatagramChannel datagramChannel) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(response);
        objectOutputStream.close();
        ByteBuffer b = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
        datagramChannel.send(b, clientAddress);
    }
}
