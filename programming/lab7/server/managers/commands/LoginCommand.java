package org.example.managers.commands;

import org.example.db.DataBaseManager;
import org.example.managers.CollectionManager;
import org.example.network.Request;
import org.example.system.Server;

public class LoginCommand implements BaseCommand{
    @Override
    public String execute(Request request, CollectionManager collectionManager) throws Exception {
        String login = request.getLogin();
        String password = request.getPassword();
        if (Server.getDataBaseManager().checkUser(login, password)){
            return "Добро пожаловать!";
        }
        return "Неверный логин или пароль";
    }

    @Override
    public String getName() {
        return "login";
    }

    @Override
    public String getDescription() {
        return "login";
    }
}
