package managers.commands;


import data.Route;
import data.comparators.RouteDisComparator;
import data.comparators.RouteNameComparator;
import generators.RouteGenerator;
import managers.CollectionManager;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveGraterCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        Route route = RouteGenerator.createRoute(0L);
        HashMap<String, Route> map = CollectionManager.getMap();

        RouteDisComparator c1 = new RouteDisComparator();
        RouteNameComparator c2 = new RouteNameComparator();
        ArrayList<String> keySet = new ArrayList<>();

        for (String key : map.keySet()) {
            if (c1.compare(route, map.get(key)) < 0) {
                keySet.add(key);
            } else if (c1.compare(route, map.get(key)) == 0) {
                if (c2.compare(route, map.get(key)) < 0) {
                    keySet.add(key);
                }
            }
        }
        int k = keySet.size();
        for (String key : keySet) {
            CollectionManager.remove(key);
        }
        if (k == CollectionManager.getMap().size()) {
            System.out.println("Nothing was changed");
        }
    }

    @Override
    public String getName() {
        return "remove_grater {element}";
    }

    @Override
    public String getDescription() {
        return "remove elements with grater than the element";
    }


}

