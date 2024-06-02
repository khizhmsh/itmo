package org.example.managers.commands;

import org.example.network.Request;
import org.example.managers.CollectionManager;
import org.example.managers.Receiver;
/**
 * Данная команда обновляет элемент коллекции по ID
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class UpdateCommand implements BaseCommand {
    @Override
    public String execute(Request request, CollectionManager collectionManager) throws Exception {
        return Receiver.update(request.getLogin(), request.getArgs(), request.getRoute(), collectionManager);
    }

    @Override
    public String getName() {
        return "update id {element}";
    }

    @Override
    public String getDescription() {
        return "update element";
    }
}
