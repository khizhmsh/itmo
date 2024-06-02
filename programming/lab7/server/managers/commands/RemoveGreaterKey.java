package org.example.managers.commands;

import org.example.network.Request;
import org.example.managers.CollectionManager;
import org.example.managers.Receiver;

/**
 * Данная команда удаляет из коллекции все элементы, ключ которых превышает заданный
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class RemoveGreaterKey implements BaseCommand {
    @Override
    public String execute(Request request, CollectionManager collectionManager) {
        return Receiver.removeGraterKey(request.getLogin(), request.getArgs(), collectionManager);
    }
    @Override
    public String getName() {
        return "remove_greater_key {element}";
    }

    @Override
    public String getDescription() {
        return "remove elements whose key exceeds the given one";
    }
}
