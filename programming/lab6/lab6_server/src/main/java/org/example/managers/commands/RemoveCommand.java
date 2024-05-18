package org.example.managers.commands;

import org.example.network.Request;
import org.example.managers.CollectionManager;
import org.example.managers.Receiver;

/**
 * Данная команда удаляет из коллекции элемент по ключу
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class RemoveCommand implements BaseCommand {
    @Override
    public String execute(Request request, CollectionManager collectionManager) throws Exception {
        return Receiver.removeCommand(request.getArgs(), collectionManager);
    }

    @Override
    public String getName() {
        return "remove_key null";
    }

    @Override
    public String getDescription() {
        return "remove_key element by key";
    }

}
