package org.example.network;

import org.example.exceptions.NotRegisterException;
import org.example.exceptions.WrongArgumentException;
import org.example.objects.Route;
import org.example.objects.generators.RouteGenerator;

public class RequestHandler {
    private static String login = "";
    private static String password = "";
    private static boolean isLogin = false;

    public static Request formRequest(String input, String[] args) throws Exception {
        Request request = new Request();
        String[] parts = input.split(" ");
        if (input.contains("login") || input.contains("reg") || isLogin) {
            if (input.contains("login") || input.contains("reg")){
                if (parts.length == 3) {
                    login = parts[1];
                    password = parts[2];
                    isLogin = false;

                    request.setCommandRequest(new CommandRequest().setNameCommand(parts[0]).setArgs(login)).setLogin(login).setPassword(password);
                    return request;
                }
                throw new WrongArgumentException("command argument");
            }
            request.setLogin(login);
            request.setPassword(password);
            if (parts.length == 1) {
                request.setCommandRequest(new CommandRequest().setNameCommand(parts[0]));
                if (input.contains("remove_greater") && !input.contains("remove_greater_key"))
                    request.setCommandRequest(request.getCommandRequest().setRoute(RouteGenerator.createRoute(0L)));
                return request;
            } else if (parts.length == 2) {
                request.setCommandRequest(new CommandRequest().setNameCommand(parts[0]).setArgs(parts[1]));

                if (isComplexCommand(input)) {
                    if (args == null) request.setCommandRequest(request.getCommandRequest().setRoute(RouteGenerator.createRoute(0L)));
                    else request.setCommandRequest(request.getCommandRequest().setRoute(new Route(args)));;
                } else {
                    request.setCommandRequest(request.getCommandRequest().setRoute(null));
                }

                return request;
            } else if (parts.length > 2) {
                throw new WrongArgumentException("command argument");
            }

            if (input.contains("exit")) {
                System.exit(0);
                return null;
            }

            throw new WrongArgumentException("argument");
        } else throw new NotRegisterException();
    }

    private static boolean isComplexCommand(String input) {
        return input.contains("insert") || input.contains("replace") || input.contains("update") ||
                (input.contains("remove_greater") && !input.contains("remove_greater_key"));
    }

    public static boolean isIsLogin() {
        return isLogin;
    }

    public static void setIsLogin(boolean isLogin) {
        RequestHandler.isLogin = isLogin;
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        RequestHandler.login = login;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        RequestHandler.password = password;
    }
}
