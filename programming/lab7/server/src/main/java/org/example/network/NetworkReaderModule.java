package org.example.network;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class NetworkReaderModule {
    private DatagramChannel datagramChannel;

    public NetworkReaderModule(DatagramChannel datagramChannel) {
        this.datagramChannel = datagramChannel;
    }

    public synchronized Request getRequest(ByteBuffer buffer) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer.array());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Request request = (Request) objectInputStream.readObject();
        System.out.println("Успешно получен запрос: " + request.getCommandRequest().getNameCommand() + " " + request.getCommandRequest().getArgs());
        return request;
    }
}
