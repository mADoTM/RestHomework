package ru.mail.common;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbConnectionHelper {
    private static final @NotNull JDBCCredentials CREDS = JDBCCredentials.DEFAULT;

    private static @Nullable Connection connection;

    public static @NotNull Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed())
            connection = DriverManager.getConnection(CREDS.url(), CREDS.login(), CREDS.password());
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null)
            connection.close();
    }

    public static void setAutoCommit(boolean autoCommit) throws SQLException {
        if (connection == null || connection.isClosed())
            getConnection();
        connection.setAutoCommit(autoCommit);
    }
}
