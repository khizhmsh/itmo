package org.example.managers.commands;


import org.example.network.Request;
import org.example.managers.CollectionManager;
import org.example.managers.Receiver;

/**
 * Данная команда удаляет из коллекции все элементы, превышающие заданный
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class RemoveGraterCommand implements BaseCommand {
    @Override
    public String execute(Request request, CollectionManager collectionManager) {
        return Receiver.removeGraterCommand(request.getLogin(), request.getRoute(), collectionManager);
    }

    @Override
    public String getName() {
        return "remove_greater {element}";
    }

    @Override
    public String getDescription() {
        return "remove elements with grater than the element";
    }


}

