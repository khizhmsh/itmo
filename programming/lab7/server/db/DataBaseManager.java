package org.example.db;


import org.example.objects.Coordinates;
import org.example.objects.Location;
import org.example.objects.Route;

import java.sql.*;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
public class DataBaseManager {

    private final String url;
    private final String username;
    private final String password;

    public DataBaseManager(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Добавление пользователя
    public boolean addUser(String user_login, String user_password) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO users (login, password) VALUES (?, ?)")) {
            statement.setString(1, user_login);
            statement.setString(2, HashHandler.encryptString(user_password));
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Ошибка при добавлении пользователя: " + e.getMessage());
            return false;
        }
    }

    public boolean checkUser(String user_login, String user_password) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement getStatement = connection.prepareStatement("SELECT id, login, password FROM users WHERE login = ?")) {
            getStatement.setString(1, user_login);
            ResultSet rs = getStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("password").equals(HashHandler.encryptString(user_password));
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Получение ID пользователя по логину
    public int getUserId(String login) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT id FROM Users WHERE login = ?")) {
            statement.setString(1, login);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при получении ID пользователя: " + e.getMessage());
        }
        return -1; // ID не найден
    }

    // Добавление дороги
    public boolean addRoute(String login, String key, Route route) {
        int userId = getUserId(login);
        if (userId == -1) {
            return false; // Пользователь не найден
        }
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO route (route_key, name, owner_id, x, y, creation_date, location_to_x, location_to_y, location_to_z, location_to_name, location_from_x, location_from_y, location_from_z, location_from_name, distance) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, key);
            statement.setString(2, route.getName());
            statement.setInt(3, userId);
            statement.setDouble(4, route.getCoordinates().getX());
            statement.setDouble(5, route.getCoordinates().getY());

            Date sqlDate = new Date(route.getCreationDate().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
            statement.setDate(6, sqlDate);

            statement.setDouble(7, route.getTo().getX());
            statement.setDouble(8, route.getTo().getY());
            statement.setInt(9, route.getTo().getZ());
            statement.setString(10, route.getTo().getName());
            statement.setDouble(11, route.getFrom().getX());
            statement.setDouble(12, route.getFrom().getY());
            statement.setInt(13, route.getFrom().getZ());
            statement.setString(14, route.getFrom().getName());
            statement.setInt(15, route.getDistance());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Ошибка при добавлении дороги: " + e.getMessage());
            return false;
        }
    }

    public boolean updateByIdRoute(String login, int id, Route route) {
        int userId = getUserId(login);
        if (userId == -1) {
            return false; // Пользователь не найден
        }
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE route SET name = ?, x = ?, y = ?, creation_date = ?, location_to_x = ?, location_to_y = ?, location_to_z = ?, location_to_name = ?, location_from_x = ?, location_from_y = ?, location_from_z = ?, location_from_name = ?, distance = ? WHERE id = ? AND owner_id = ?")) {
            statement.setInt(14, id);
            statement.setInt(15, userId);
            statement.setString(1, route.getName());
            statement.setDouble(2, route.getCoordinates().getX());
            statement.setDouble(3, route.getCoordinates().getY());

            Date sqlDate = new Date(route.getCreationDate().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
            statement.setDate(4, sqlDate);

            statement.setDouble(5, route.getTo().getX());
            statement.setDouble(6, route.getTo().getY());
            statement.setInt(7, route.getTo().getZ());
            statement.setString(8, route.getTo().getName());
            statement.setDouble(9, route.getFrom().getX());
            statement.setDouble(10, route.getFrom().getY());
            statement.setInt(11, route.getFrom().getZ());
            statement.setString(12, route.getFrom().getName());
            statement.setInt(13, route.getDistance());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Ошибка при обновлении дороги: " + e.getMessage());
            return false;
        }
    }

    public boolean updateByKeyRoute(String login, String key, Route route) {
        int userId = getUserId(login);
        if (userId == -1) {
            return false; // Пользователь не найден
        }
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE route SET name = ?, x = ?, y = ?, creation_date = ?, location_to_x = ?, location_to_y = ?, location_to_z = ?, location_to_name = ?, location_from_x = ?, location_from_y = ?, location_from_z = ?, location_from_name = ?, distance = ? WHERE route_key = ? AND owner_id = ?")) {
            statement.setString(14, key);
            statement.setInt(15, userId);
            statement.setString(1, route.getName());
            statement.setDouble(2, route.getCoordinates().getX());
            statement.setDouble(3, route.getCoordinates().getY());

            Date sqlDate = new Date(route.getCreationDate().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
            statement.setDate(4, sqlDate);

            statement.setDouble(5, route.getTo().getX());
            statement.setDouble(6, route.getTo().getY());
            statement.setInt(7, route.getTo().getZ());
            statement.setString(8, route.getTo().getName());
            statement.setDouble(9, route.getFrom().getX());
            statement.setDouble(10, route.getFrom().getY());
            statement.setInt(11, route.getFrom().getZ());
            statement.setString(12, route.getFrom().getName());
            statement.setInt(13, route.getDistance());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Ошибка при обновлении дороги: " + e.getMessage());
            return false;
        }
    }

    // Удаление дороги
    public boolean deleteRoute(String login, String routeKey) {
        int userId = getUserId(login);
        if (userId == -1) {
            return false; // Пользователь не найден
        }
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM route WHERE route_key = ? AND owner_id = ?")) {
            statement.setString(1, routeKey);
            statement.setInt(2, userId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Ошибка при удалении дороги: " + e.getMessage());
            return false;
        }
    }

    // Получение списка дорог пользователя
    public HashMap<String, Route> getRoutes() {
        HashMap<String, Route> routes = new HashMap<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM route")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Route route = new Route();
                    route.setId((long) resultSet.getInt("id"));
                    route.setName(resultSet.getString("name"));
                    route.setCoordinates(new Coordinates(resultSet.getDouble("x"), (long) resultSet.getDouble("y")));
                    // route.setCreationDate(resultSet.getDate("creation_date"));
                    route.setFrom(new Location((float) resultSet.getInt("location_from_x"),
                            (float) resultSet.getInt("location_from_y"),
                            resultSet.getInt("location_from_z"),
                            resultSet.getString("location_from_name")));
                    route.setTo(new Location((float) resultSet.getInt("location_to_x"),
                            (float) resultSet.getInt("location_to_y"),
                            resultSet.getInt("location_to_z"), resultSet.getString("location_to_name")));
                    route.setDistance(resultSet.getInt("distance"));
                    routes.put(resultSet.getString("route_key"), route);
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при получении списка дорог: " + e.getMessage());
        }
        return routes;
    }
}

