package org.example.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class NetworkSenderModule {
    private DatagramChannel datagramChannel;
    private InetSocketAddress clientAddress;

    public NetworkSenderModule(DatagramChannel datagramChannel) {
        this.datagramChannel = datagramChannel;
    }

    public void sendResponse(Response response, InetSocketAddress clientAddress) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(response);
        objectOutputStream.close();
        ByteBuffer b = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
        System.out.println(response.getMessage() + " " + clientAddress.toString());
        datagramChannel.send(b, clientAddress);
    }
}
