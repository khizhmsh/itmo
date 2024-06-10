package org.example.db;

public class requestDDL {
    private static final String createUsersTable = "CREATE TABLE  IF NOT EXISTS users(\n" +
            "  id serial PRIMARY KEY,\n" +
            "  login varchar(70) UNIQUE NOT NULL,\n" +
            "  password TEXT NOT NULL\n" +
            ");";
    private static final String createRoutesTable = "CREATE TABLE IF NOT EXISTS route (\n" +
            "  id SERIAL PRIMARY KEY,\n" +
            "  route_key varchar(70) NOT NULL UNIQUE,\n" +
            "  name varchar(70) NOT NULL,\n" +
            "  owner_id int REFERENCES Users(id),\n" +
            "  x DOUBLE PRECISION NOT NULL,\n" +
            "  y DOUBLE PRECISION NOT NULL,\n" +
            "  creation_date DATE NOT NULL,\n" +
            "  location_to_x DOUBLE PRECISION NOT NULL,\n" +
            "  location_to_y DOUBLE PRECISION NOT NULL,\n" +
            "  location_to_z int NOT NULL,\n" +
            "  location_to_name varchar(70),\n" +
            "  location_from_x DOUBLE PRECISION NOT NULL,\n" +
            "  location_from_y DOUBLE PRECISION NOT NULL,\n" +
            "  location_from_z int NOT NULL,\n" +
            "  location_from_name varchar(70),\n" +
            "  distance int NOT NULL\n" +
            ");";

    public static String getCreateUsersTable() {
        return createUsersTable;
    }

    public static String getCreateRoutesTable() {
        return createRoutesTable;
    }

}
