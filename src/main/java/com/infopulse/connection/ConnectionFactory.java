package com.infopulse.connection;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final Logger logger = Logger.getLogger(ConnectionFactory.class);
    private static PropertiesFileData propFileData = new PropertiesFileData();


    public static Connection getConnection() {
        try {
            Class.forName(propFileData.getProper().getProperty("DB_DRIVER_CLASS"));
        } catch (ClassNotFoundException e) {
            logger.error(e);
        }
        try {
            return DriverManager.getConnection(propFileData.getProper().getProperty("DB_URL"),
                    propFileData.getProper().getProperty("DB_USERNAME"),
                    propFileData.getProper().getProperty("DB_PASSWORD"));

        } catch (SQLException e) {
            logger.error("Connection to DB is abort ", e);
            throw new RuntimeException("Connection to DB is abort ", e);
        }

    }

}
