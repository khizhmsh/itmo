package data.comparators;

import data.Route;

import java.util.Comparator;

public class RouteNameComparator implements Comparator<Route> {
    @Override
    public int compare(Route s1, Route s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

