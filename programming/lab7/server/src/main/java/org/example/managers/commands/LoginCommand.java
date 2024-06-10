package org.example.managers.commands;

import org.example.managers.CollectionManager;
import org.example.network.CommandRequest;
import org.example.network.Request;
import org.example.system.Server;

public class LoginCommand implements BaseCommand{
    @Override
    public String execute(Request request, CollectionManager collectionManager) throws Exception {
        String login = request.getLogin();
        String password = request.getPassword();
        if (CollectionManager.getDataBaseManager().checkUser(login, password)){
            return "Добро пожаловать!";
        }
        return "Неверный логин или пароль";
    }

    @Override
    public String getName() {
        return "log";
    }

    @Override
    public String getDescription() {
        return "login";
    }
}
