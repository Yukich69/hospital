package com.solvd.hospital.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ConnectionPool {
    private String databaseUrl;
    private String userName;
    private String password;

    private int maxPoolSize = 10;
    private int connectNum = 0;

    private static final String SQL_VERIFY = "select 1";
    Stack<Connection> freePool = new Stack<>();
    Set<Connection> occupiedPool = new HashSet<>();

    public ConnectionPool(String databaseUrl, String userName, String password, int maxPoolSize){
        this.databaseUrl = databaseUrl;
        this.userName = userName;
        this.password = password;
        this.maxPoolSize = maxPoolSize;
    }

    public synchronized void returnConnection(Connection con) throws SQLException {
        if (con == null) {
            throw new NullPointerException();
        }
        if(!occupiedPool.remove(con)) {
            throw new SQLException("iSNT FOR THIS POOL");
        }
        freePool.push(con);
    }

    public synchronized Connection getConnection() throws SQLException{
        Connection con = null;
        if (isFull()){
            throw new SQLException("Pool is full");
        }
        if(con == null){
            con = createNewConnectionForPool();
        }
        con = makeAvailable(con);
        return con;
    }

    private Connection getConnectionFromPool(){
        Connection con = null;
        if(freePool.size() > 0){
            con = freePool.pop();
            occupiedPool.add(con);
        }
        return con;
    }
    private Connection createNewConnectionForPool() throws SQLException {
        Connection con = createNewConnection();
        connectNum++;
        occupiedPool.add(con);
        return con;
    }

    private Connection createNewConnection() throws SQLException {
        Connection con = null;
        con = DriverManager.getConnection(databaseUrl, userName, password);
        return con;
    }

    private Connection makeAvailable(Connection con) throws SQLException {
        if (isConnectAvailable(con)) {
        return con;
        }
        occupiedPool.remove(con);
        connectNum--;
        con.close();

        con = createNewConnection();
        occupiedPool.add(con);
        connectNum++;
        return con;
    }

    private boolean isConnectAvailable(Connection con) {
        try(Statement st = con.createStatement()) {
            st.executeQuery(SQL_VERIFY);
            return true;
        }catch (SQLException e) {
            return false;
        }
    }

    private  synchronized boolean isFull() {
        return ((freePool.size() == 0) && (connectNum >= maxPoolSize));
    }
}
