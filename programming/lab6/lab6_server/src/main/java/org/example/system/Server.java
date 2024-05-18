package org.example.system;

import org.example.network.Request;
import org.example.network.Response;
import org.example.exceptions.RootException;
import org.example.exceptions.WrongArgumentException;
import org.example.managers.CollectionManager;
import org.example.managers.CommandManager;
import org.example.managers.FileManager;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Server {
    private DatagramChannel datagramChannel;
    private CollectionManager collectionManager;
    public static String data_path = "";

    public Server(int port, String path) throws IOException, WrongArgumentException, ParserConfigurationException, RootException, SAXException {
        data_path = path;
        datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);
        datagramChannel.bind(new InetSocketAddress(port));
        collectionManager = new CollectionManager();
        FileManager.read(collectionManager);
        new CommandManager();
    }

    public void listen() {
        System.out.println("Сервер запущен");
        while (true) {
            try {
                ByteBuffer buffer = ByteBuffer.allocate(500000);
                InetSocketAddress clientAddress = (InetSocketAddress) datagramChannel.receive(buffer);
                buffer.flip();
                Request request = IOManager.getRequest(buffer, clientAddress);
                Response response = execute(request);
                IOManager.sendResponse(response, clientAddress, datagramChannel);
            } catch (IOException | ClassNotFoundException e) {

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
}