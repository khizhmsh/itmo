package org.example.network;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class NetworkReaderModule {
    private DatagramChannel datagramChannel;
    private InetSocketAddress clientAddress;

    public NetworkReaderModule(DatagramChannel datagramChannel) {
        this.datagramChannel = datagramChannel;
    }



    public synchronized Request getRequest() throws IOException, ClassNotFoundException {
        ByteBuffer buffer = ByteBuffer.allocate(500000);
        clientAddress = (InetSocketAddress) datagramChannel.receive(buffer);
        buffer.flip();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer.array());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Request request = (Request) objectInputStream.readObject();
        System.out.println("Получено сообщение от " + clientAddress + ": " + request.getNameCommand() + " " + request.getArgs());
        return request;
    }

    public DatagramChannel getDatagramChannel() {
        return datagramChannel;
    }

    public InetSocketAddress getClientAddress() {
        return clientAddress;
    }
}
