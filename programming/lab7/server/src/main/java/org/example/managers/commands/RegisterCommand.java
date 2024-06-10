package org.example.managers.commands;

import org.example.managers.CollectionManager;
import org.example.network.Request;
import org.example.system.Server;

public class RegisterCommand implements BaseCommand{
    @Override
    public String execute(Request request, CollectionManager collectionManager) throws Exception {
        String login = request.getLogin();
        String password = request.getPassword();
        if (CollectionManager.getDataBaseManager().addUser(login, password)){
            return "Добро пожаловать!";
        }
        return "Пользователь с таким именем уже существует";
    }

    @Override
    public String getName() {
        return "reg";
    }

    @Override
    public String getDescription() {
        return "register";
    }
}
