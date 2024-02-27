package managers.commands;

import data.Route;
import managers.CollectionManager;

import java.util.HashMap;

public class RemoveGreaterKey implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        HashMap<String, Route> map = CollectionManager.getMap();
        for (String key : map.keySet()) {
            if (key.compareTo(args[1]) > 0) {
                CollectionManager.remove(key);
                System.out.println("Element with key " + key + " was deleted");
            }
        }
    }


    @Override
    public String getName() {
        return "remove_grater {element}";
    }

    @Override
    public String getDescription() {
        return "remove elements whose key exceeds the given one";
    }
}
