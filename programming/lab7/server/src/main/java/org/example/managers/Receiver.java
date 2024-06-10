package org.example.managers;

import org.example.db.DataBaseManager;
import org.example.exceptions.*;
import org.example.managers.commands.BaseCommand;
import org.example.objects.Route;
import org.example.objects.comparators.RouteDisComparator;
import org.example.objects.comparators.RouteNameComparator;
import org.example.network.Request;
import org.example.system.Server;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class Receiver {

    public static String clear(String login) {
        if (CollectionManager.getDataBaseManager().clearUserCollection(login)) {
            CollectionManager.setMap(CollectionManager.getDataBaseManager().getRoutes());
            return "Your collection was cleared";
        }
        return "Your collection is already clear";
    }

    public static String filterContains(String nameSubstring) {
        HashMap<String, Route> map = CollectionManager.getMap();
        String a = map.values().stream()
                .filter(route -> route.getName().contains(nameSubstring))
                .map(Route::toString)
                .collect(Collectors.joining("\n"));
        if (!a.isEmpty()) return a;
        return "No founded routes";
    }

    public static String filterGreater(String distanceStr) {
        HashMap<String, Route> map = CollectionManager.getMap();
        int distance = Integer.parseInt(distanceStr);
        String a = map.values().stream()
                .filter(route -> route.getDistance() > distance)
                .map(Route::toString)
                .collect(Collectors.joining("\n"));
        if (!a.isEmpty()) return a;
        return "No founded routes";
    }

    public static String help() throws Exception {
        StringBuilder st = new StringBuilder();
        CommandManager commandManager = new CommandManager();
        HashMap<String, BaseCommand> commandList = commandManager.getCommandList();
        for (String name : commandList.keySet()) {
            BaseCommand command = commandList.get(name);
            st.append(command.getName() + " - " + command.getDescription()).append("\n");
        }
        return st.toString();
    }

    public static String info() throws Exception {
        StringBuilder st = new StringBuilder();
        st.append("Data type - " + CollectionManager.getMap().getClass().getName()).append("\n");
        st.append("Count of routes - " + CollectionManager.getMap().keySet().size()).append("\n");
        st.append("Init date - " + CollectionManager.getInitDate()).append("\n");
        return st.toString();
    }

    public static String insert(String login, String arg, Route route, CollectionManager collectionManager) throws WrongArgumentException {
        try {
            if (CollectionManager.getDataBaseManager().addRoute(login, arg, route)) {
                route.setId(CollectionManager.getDataBaseManager().getRouteId(arg));
                collectionManager.add(arg, route);
                return "Element was added";
            } else return "Element with key '" + arg + "' is already exist";
        } catch (SQLException e) {
            return "Element with key '" + arg + "' is already exist";
        }
    }

    public static String printUnique() {
        HashMap<String, Route> map = CollectionManager.getMap();
        return map.values().stream()
                .map(Route::getDistance)
                .distinct()
                .map(String::valueOf) // Преобразуем числа в строки
                .collect(Collectors.joining("\n"));
    }

    public static String removeCommand(String login, String arg, CollectionManager collectionManager) {
        try {
            if (CollectionManager.getDataBaseManager().deleteRoute(login, arg)) {
                collectionManager.remove(arg);
                return "Element was removed";
            } else return "No founded routes";
        } catch (SQLException | NoElementException e) {
            return "ERROR: " + e.getMessage();
        }

    }

    public static String removeGraterCommand(String login, Route route, CollectionManager collectionManager) {
        Map<String, Route> map = CollectionManager.getMap();
        RouteDisComparator c1 = new RouteDisComparator();
        RouteNameComparator c2 = new RouteNameComparator();
        int k = CollectionManager.getMap().size();
        try {
            long countRemoved = map.entrySet().stream()
                    .filter(entry -> c1.compare(route, entry.getValue()) < 0
                            || (c1.compare(route, entry.getValue()) == 0 && c2.compare(route, entry.getValue()) < 0))
                    .peek(entry -> {
                        try {
                            if (CollectionManager.getDataBaseManager().deleteRoute(login, entry.getKey())) {
                                collectionManager.remove(entry.getKey());
                            }
                        } catch (SQLException | NoElementException e){
                            throw new RuntimeException(e);
                        }
                    }) // Удаляем элемент внутри stream
                    .count();
            if (countRemoved > 0) return countRemoved + " elements were deleted";
            else return "No founded routes";
        } catch (ConcurrentModificationException e) {
            return k - CollectionManager.getMap().size() + " elements were deleted";
        } catch (Exception e) {
            return "ERROR: " + e.getMessage();
        }
    }


    public static String removeGraterKey(String login, String key, CollectionManager collectionManager) {
        int k = CollectionManager.getMap().size();
        try {
            CollectionManager.getMap().entrySet().stream()
                    .filter(entry -> entry.getKey().compareTo(key) > 0)
                    .forEach(entry -> {
                        try {
                            if (CollectionManager.getDataBaseManager().deleteRoute(login, entry.getKey())) {
                                collectionManager.remove(entry.getKey());
                            }
                        } catch (SQLException | NoElementException e) {
                            throw new RuntimeException(e);
                        }
                    });
            if (k - CollectionManager.getMap().size() != 0)
            return k - CollectionManager.getMap().size() + " elements were deleted";
            else return "No founded routes";
        } catch (ConcurrentModificationException e) {
            return k - CollectionManager.getMap().size() + " elements were deleted";
        } catch (Exception e) {
            return "No founded routes: " + e.getMessage();
        }
    }

    public static String replace(String login, String key, Request request, CollectionManager collectionManager) {
        HashMap<String, Route> map = CollectionManager.getMap();
        RouteDisComparator c1 = new RouteDisComparator();
        if (CollectionManager.getMap().containsKey(key)) {
            Route route = request.getCommandRequest().getRoute();
            if (c1.compare(route, map.get(key)) > 0) {
                if (CollectionManager.getDataBaseManager().updateByKeyRoute(login, key, route)) {
                    try {
                        route.setId(CollectionManager.getMap().get(key).getId());
                        collectionManager.remove(key);
                        collectionManager.add(key, route);
                        return "Element was updated";
                    } catch (NoElementException e) {
                        return "ERROR" + e.getMessage();
                    }

                } return "It isn't your element";
            }
            return "New element less than old";
        }
        return "No founded routes";
    }


    public static String show() {
        StringBuilder st = new StringBuilder();

        HashMap<String, Route> map = CollectionManager.getMap();
        Map<String, Route> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((route1, route2) -> Double.compare(route1.getDistance(), route2.getDistance())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (String x : sortedMap.keySet()) {
            st.append("key = " + x + " " + map.get(x)).append("\n");
        }
        if (map.isEmpty()) {
            return CollectionManager.getMap().getClass().getName() + " is empty";
        }
        return st.toString();
    }

    public static String update(String login, String arg, Route route, CollectionManager collectionManager) throws NoElementException {
        Long id = Long.parseLong(arg);
        for (String key : CollectionManager.getMap().keySet()) {
            if (CollectionManager.getMap().get(key).getId().equals(id)) {
                if (CollectionManager.getDataBaseManager().updateByIdRoute(login, Math.toIntExact(id), route)) {
                    route.setId(CollectionManager.getMap().get(key).getId());
                    collectionManager.remove(key);
                    collectionManager.add(key, route);
                    return "Element was updated";
                }
                return "It isn't your element";
            }
        }
        throw new NoElementException(id);
    }

}
