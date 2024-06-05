package org.example.db;

public class requestDML {
    private static final String insertUser = "INSERT INTO users (login, password) VALUES (?, ?)";
    private static final String checkUser = "SELECT id, login, password FROM users WHERE login = ?";
    private static final String getIdByLogin = "SELECT id FROM Users WHERE login = ?";
    private static final String insertRoute = "INSERT INTO route (route_key, name, owner_id, x, y, creation_date, location_to_x, location_to_y, location_to_z, location_to_name, location_from_x, location_from_y, location_from_z, location_from_name, distance) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String updateRoute = "UPDATE route SET name = ?, x = ?, y = ?, creation_date = ?, location_to_x = ?, location_to_y = ?, location_to_z = ?, location_to_name = ?, location_from_x = ?, location_from_y = ?, location_from_z = ?, location_from_name = ?, distance = ? WHERE id = ? AND owner_id = ?";
    private static final String deleteRoute = "DELETE FROM route WHERE route_key = ? AND owner_id = ?";
    private static final String selectAllRoutes = "SELECT * FROM route";
    private static final String selectIdFromRoute = "SELECT id FROM route WHERE route_key = ?";
    public static String getInsertUser() {
        return insertUser;
    }

    public static String getCheckUser() {
        return checkUser;
    }

    public static String getGetIdByLogin() {
        return getIdByLogin;
    }

    public static String getInsertRoute() {
        return insertRoute;
    }

    public static String getUpdateRoute() {
        return updateRoute;
    }

    public static String getDeleteRoute() {
        return deleteRoute;
    }

    public static String getSelectAllRoutes() {
        return selectAllRoutes;
    }

    public static String getSelectIdFromRoute() {
        return selectIdFromRoute;
    }
}
