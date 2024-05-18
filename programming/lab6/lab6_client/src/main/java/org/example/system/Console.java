package org.example.system;

import org.example.exceptions.BuildRouteException;
import org.example.exceptions.WrongArgumentException;
import org.example.network.Request;
import org.example.network.RequestHandler;
import org.example.network.Response;

import java.io.IOException;
import java.util.Scanner;

public class Console {
    public static void start(Server server) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                try {
                    if (input.contains("execute_script")) {
                        ScriptReader.read(input.split(" ")[1], server);
                    } else {
                        Request request = RequestHandler.formRequest(input, null);
                        server.send(request);
                        Response response = server.getResponse();
                        System.out.println(response.getMessage());
                    }
                } // проверить на ошибки
                catch (IOException e) {
                    System.out.println(e.getClass() + " " + e.getMessage());
                    server.reconnect();
                } catch (ClassNotFoundException | WrongArgumentException | BuildRouteException |
                         InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


