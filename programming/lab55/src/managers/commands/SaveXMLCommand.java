package managers.commands;

import managers.CollectionManager;
import managers.Receiver;

/**
 * Данная команда сохраняет коллекцию в формате XML
 *
 * @author khizhmsh
 * @see BaseCommand
 * @since 1.0
 */

public class SaveXMLCommand implements BaseCommand {
    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws Exception {
        Receiver.saveFile();
    }


    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "save data to XML file (path)";
    }
}

