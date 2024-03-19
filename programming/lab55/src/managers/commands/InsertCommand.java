package managers.commands;

import managers.Receiver;
import resources.Route;
import exceptions.BuildRouteException;
import exceptions.WrongArgumentException;
import resources.generators.RouteGenerator;
import managers.CollectionManager;
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
    public void execute(String[] args, CollectionManager collectionManager) throws WrongArgumentException {
        Receiver.insert(args,collectionManager);
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

