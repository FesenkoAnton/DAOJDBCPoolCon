package com.infopulse.connection;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionFactory {
    static Properties proper = new Properties();
    private static String pathToProper = "C:/Projects/statement1/lib/db.properties";

//    private static ConnectionFactory connectionFactory = new ConnectionFactory();
//
//    ConnectionFactory(){
//        getPropertiesConnection();
//    }
//
//    public static ConnectionFactory getInstance(){
//        return connectionFactory;
//    }

    public static Connection getConnection() {
        getPropertiesConnection();
        try {
            Class.forName(proper.getProperty("DB_DRIVER_CLASS"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        }
        try {
            return DriverManager.getConnection(proper.getProperty("DB_URL"), proper.getProperty("DB_USERNAME"), proper.getProperty("DB_PASSWORD"));
        } catch (SQLException e) {
            throw new RuntimeException("Connection to DB is abort ", e);
        }
    }

    private static void getPropertiesConnection() {
        FileInputStream fileInStr = null;
        try {
            fileInStr = new FileInputStream(pathToProper);
            try {
                proper.load(fileInStr);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File Not Found properties", e);
        }
    }
}
