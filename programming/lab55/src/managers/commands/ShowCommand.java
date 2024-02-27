package managers.commands;

import data.Route;
import managers.CollectionManager;

import java.util.HashMap;
import java.util.Hashtable;

public class ShowCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        HashMap<String, Route> map = CollectionManager.getMap();
        for (String x : map.keySet()) {
            System.out.println(map.get(x));
        }
        if (map.isEmpty()) {
            System.out.println(CollectionManager.getMap().getClass().getName() + " is empty");
        }
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "show data";
    }

}
