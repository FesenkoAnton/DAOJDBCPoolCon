package com.infopulse.connection;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class ConnectPool {
    private static final Logger logger = Logger.getLogger(ConnectPool.class);
    private final int MAX_CONNECT=5;
    private List<Connection> conn = new ArrayList<>();

    ConnectPool(){
        fullConnectPool();
    }

    private void fullConnectPool() {
        while (!checkPoolIsFull()) {
            conn.add(ConnectionFactory.getConnection());
        }
    }

    private synchronized boolean checkPoolIsFull() {
        if (conn.size() < MAX_CONNECT) {
            return false;
        }
        return true;
    }

    public synchronized Connection getFromPoolCon() {
        Connection connection = null;
        if (conn.size() > 0) {
            connection = conn.get(0);
            conn.remove(0);
        }
        return connection;
    }

    public synchronized void conToPool(Connection connection) {
        if(conn.size() < 5) {
            conn.add(connection);
        }else{
            logger.error("try do conn.size > max value.");
        }
    }


}