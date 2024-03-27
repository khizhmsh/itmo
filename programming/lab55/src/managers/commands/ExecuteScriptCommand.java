package managers.commands;

import managers.Receiver;
import resources.Route;
import managers.CollectionManager;
import managers.CommandManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/**
 * Данная команда исполняет скрипт из файла
 *
 * @author khizhmsh
 * @see BaseCommand
 * @since 1.0
 */
public class ExecuteScriptCommand implements BaseCommand {
    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws Exception {
        Receiver.executeScript(args, collectionManager);
    }

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return "execute script from file";
    }
}
