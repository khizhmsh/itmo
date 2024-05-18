package org.example.network;

import org.example.exceptions.WrongArgumentException;
import org.example.objects.Route;
import org.example.objects.generators.RouteGenerator;

public class RequestHandler {
    public static Request formRequest(String input, String[] args) throws Exception {
        Route route = null;
        Request request = new Request();
        if (input.contains("insert") || input.contains("replace") || input.contains("update") || (input.contains("remove_greater") && !input.contains("remove_greater_key"))) {
            if (input.split(" ").length == 2 && args == null) {
                route = RouteGenerator.createRoute(0L);
            } else if (input.split(" ").length == 2) {
                route = new Route(args);
            } else if (input.split(" ").length != 2) {
                throw new WrongArgumentException("argument");
            }
            request.setNameCommand(input.split(" ")[0]);
            request.setArgs(input.split(" ")[1]);
            request.setRoute(route);
            return request;
        } else if (input.contains("exit")) {
            System.exit(0);
            return null;
        } else if (input.contains("remove_greater_key") | input.contains("remove_key") | input.contains("filter_contains_name") | input.contains("filter_greater_than_distance")) {
            if (input.split(" ").length == 2) {
                request.setNameCommand(input.split(" ")[0]);
                request.setArgs(input.split(" ")[1]);
                return request;
            } else {
                throw new WrongArgumentException("argument");
            }
        } else {
            if (input.split(" ").length == 1) {
                request.setNameCommand(input.split(" ")[0]);
                return request;
            } else {
                throw new WrongArgumentException("command argument");
            }
        }

    }
}
