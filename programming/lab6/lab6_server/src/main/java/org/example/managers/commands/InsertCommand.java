package org.example.managers.commands;

import org.example.network.Request;
import org.example.exceptions.WrongArgumentException;
import org.example.managers.CollectionManager;
import org.example.managers.Receiver;
import org.example.objects.Route;
/**
 * Данная команда добавляет новый элемент по ключу
 *
 * @see BaseCommand
 * @see Route
 * @author khizhmsh
 * @since 1.0
 */
public class InsertCommand implements BaseCommand {
    @Override
    public String execute(Request request, CollectionManager collectionManager) throws WrongArgumentException {
        return Receiver.insert(request.getArgs(), request.getRoute(), collectionManager);
    }


    @Override
    public String getName() {
        return "insert null {element}";
    }

    @Override
    public String getDescription() {
        return "insert new element";
    }
}

