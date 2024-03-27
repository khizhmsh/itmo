package managers.commands;

import managers.CollectionManager;
import managers.Receiver;

/**
 * Данная команда очищает коллекцию
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class ClearCommand implements BaseCommand {

    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws Exception {
        Receiver.clear();

    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "clear data from table";
    }
}
