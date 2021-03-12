package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();
        try {
            userService.createUsersTable();
            userService.saveUser("Вячеслав", "Молотов", (byte) 55);
            userService.saveUser("Лев", "Троцкий", (byte) 44);
            userService.saveUser("Иосиф", "Джугашвили", (byte) 33);
            userService.saveUser("Владимир", "Ленин", (byte) 22);
            userService.getAllUsers();
            userService.cleanUsersTable();
            userService.dropUsersTable();
            userService.closeConnection();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
