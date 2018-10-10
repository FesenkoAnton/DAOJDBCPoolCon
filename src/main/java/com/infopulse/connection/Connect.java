package com.infopulse.connection;

import java.sql.Connection;

public class Connect {

    private static ConnectPool connectPool = new ConnectPool();

    public static Connection getConn(){
        Connection connection = connectPool.getFromPoolCon();
        return connection;
    }

    public static void putConn(Connection connection){
        connectPool.conToPool(connection);
    }

}
