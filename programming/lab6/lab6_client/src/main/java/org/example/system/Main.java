package org.example.system;


public class Main {
    public static void main(String[] args) {
        try{
            String host = args[0];
            int serverPort = Integer.parseInt(args[1]);
            Server server = new Server(host, serverPort);
            Console.start(server);
        } catch (Exception e){
            System.out.println("Something wrong with program: " + e.getMessage());
        }

    }
}