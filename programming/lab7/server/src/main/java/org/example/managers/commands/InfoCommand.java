package org.example.managers.commands;

import org.example.network.Request;
import org.example.managers.CollectionManager;
import org.example.managers.Receiver;

/**
 * Данная команда выводит данные о программе
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class InfoCommand implements BaseCommand {
    @Override
    public String execute(Request request, CollectionManager collectionManager) throws Exception {

        return Receiver.info();
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "information about app";
    }
}


