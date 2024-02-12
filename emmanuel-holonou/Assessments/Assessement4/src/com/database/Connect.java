package com.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    private static Connect instance;

    private Connection connection;

    public Connect(String name, String passwd) {
        String connectionUrl = "jdbc:postgresql://localhost:5432/assessment4";
        try {
            connection = DriverManager.getConnection(connectionUrl, name, passwd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static Connect getInstance(String name, String passwd) {
        if (instance == null) return instance = new Connect(name, passwd);
        return instance;
    }
    public Connection getConnection() {
        return connection;
    }
}
