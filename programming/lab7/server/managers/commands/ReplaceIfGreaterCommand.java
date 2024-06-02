package org.example.managers.commands;

import org.example.network.Request;
import org.example.managers.CollectionManager;
import org.example.managers.Receiver;

/**
 * Данная команда заменяет значение по ключу, если новое значение больше старого
 *
 * @author khizhmsh
 * @see BaseCommand
 * @since 1.0
 */
public class ReplaceIfGreaterCommand implements BaseCommand {
    @Override
    public String execute(Request request, CollectionManager collectionManager) throws Exception {
        return Receiver.replace(request.getLogin(), request.getArgs(), request, collectionManager);
    }

    @Override
    public String getName() {
        return "replace_if_greater";
    }

    @Override
    public String getDescription() {
        return "null {element} - update element by key if new bigger than element in collection with the same key";
    }

}