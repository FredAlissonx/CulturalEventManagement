package org.com.culturaleventmanagementsystem.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionDAO {
    private static final String URL = "jdbc:postgresql://localhost/cultural_event_management";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    private static final BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    private DatabaseConnectionDAO() {
        // Private constructor to prevent instantiation
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}