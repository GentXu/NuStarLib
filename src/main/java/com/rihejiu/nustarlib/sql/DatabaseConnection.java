package com.rihejiu.nustarlib.sql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private final HikariDataSource dataSource;

    public Connection getConnection() {
        return connection;
    }

    private Connection connection;
    public DatabaseConnection(String databaseType, String host, int port, String databaseName, String username, String password) {
        HikariConfig config = new HikariConfig();
        if (databaseType.equalsIgnoreCase("mysql")){
            config.setJdbcUrl("jdbc:mysql://" + host + ":" + port + "/" + databaseName + "?useSSL=false");
            config.setUsername(username);
            config.setPassword(password);
        } else {
            throw  new IllegalArgumentException("Unsupported database type: " + databaseType);
        }
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        dataSource = new HikariDataSource(config);
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e){
            e.printStackTrace();
            connection = null;
        }
    }
    public void connect() {
        try {
            if (connection == null)
                connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
