package managers.commands;

import data.Route;
import managers.CollectionManager;

import java.util.HashMap;

public class FilterContainsName implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        HashMap<String, Route> map = CollectionManager.getMap();
        for (String key : map.keySet()) {
            if (map.get(key).getName().contains(args[1])) {
                System.out.println(map.get(key));
            }
        }
    }

    @Override
    public String getName() {
        return "filter_name";
    }

    @Override
    public String getDescription() {
        return "display elements whose name field value contains a substring";
    }
}
