package data.comparators;

import data.Route;

import java.util.Comparator;

public class RouteDisComparator implements Comparator<Route> {
    @Override
    public int compare(Route s1, Route s2) {
        return s1.getDistance() - s2.getDistance();
    }

}
