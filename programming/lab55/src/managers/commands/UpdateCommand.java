package managers.commands;

import managers.Receiver;
import resources.Route;
import exceptions.NoElementException;
import resources.generators.RouteGenerator;
import managers.CollectionManager;
/**
 * Данная команда обновляет элемент коллекции по ID
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class UpdateCommand implements BaseCommand {
    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws Exception {
        Receiver.update(args, collectionManager);
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
