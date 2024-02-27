package managers.commands;

import data.Route;
import managers.CollectionManager;

import java.util.HashMap;

public class FilterGreaterThanDistance implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        HashMap<String, Route> map = CollectionManager.getMap();
        for (String key : map.keySet()) {
            if (Integer.parseInt(args[1]) < map.get(key).getDistance()) {
                System.out.println(map.get(key));
            }
        }
    }

    @Override
    public String getName() {
        return "filter_distance";
    }

    @Override
    public String getDescription() {
        return "display elements whose distance field value is greater than a given one";
    }

}
