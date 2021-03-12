package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "vvedgee";
    private static final String PASSWORD = "Qq4709605";
    private Connection connection = null;

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД Установлено!");
            }
        } catch (SQLException e) {
            System.err.println("Не удалось загрузить класс драйвера");
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Соединение с БД Закрыто!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
