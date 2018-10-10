package com.infopulse.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileData {

    private Properties proper;
    private String pathToProper = "C:\\Projects\\DAOJDBCPoolCon\\src\\main\\resources\\db.properties";

    public PropertiesFileData() {
        getPropertiesConnection();
    }

    public Properties getProper() {
        return proper;
    }

    private void getPropertiesConnection() {
        proper = new Properties();
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
