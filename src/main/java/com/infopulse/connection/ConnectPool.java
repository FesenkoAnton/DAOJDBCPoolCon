package com.infopulse.connection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectPool {
    List<Connection> conn = new ArrayList<Connection>();

    ConnectPool(){
        fullConnectPool();
    }

    private void fullConnectPool() {
        while (!checkPoolIsFull()) {
            conn.add(ConnectionFactory.getConnection());
        }
    }

    private synchronized boolean checkPoolIsFull() {
        final int MAX_CONNECT = Integer.parseInt(ConnectionFactory.proper.getProperty("DB_MAX_CONNECTIONS"));
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
        conn.add(connection);
    }


}