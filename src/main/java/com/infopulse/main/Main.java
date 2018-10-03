package com.infopulse.main;


import com.infopulse.connection.ConnectionFactory;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();

    }
}