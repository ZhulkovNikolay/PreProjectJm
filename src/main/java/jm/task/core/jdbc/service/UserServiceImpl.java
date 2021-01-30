package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.List;

public class UserServiceImpl extends Util implements UserService {

   // UserDao userDao = new UserDaoJDBCImpl();
    UserDao userDao = new UserDaoHibernateImpl();

    public void createUsersTable() {
        try {
            userDao.createUsersTable();
        } catch (SQLException throwables) {
            System.err.println("Не удалось создать Базу Данных");
            throwables.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try {
            userDao.dropUsersTable();
        } catch (SQLException throwables) {
            System.err.println("Не удалось удалить таблицу");
            throwables.printStackTrace();
        }
    }


    public void saveUser(String name, String lastName, byte age) {
        try {
            userDao.saveUser(name, lastName, age);
        } catch (SQLException throwables) {
            System.err.println("Не удалось создать User");
            throwables.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try {
            userDao.removeUserById(id);
        } catch (SQLException throwables) {
            System.err.println("Не удалось удалить User");
            throwables.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = null;
        try {
            userList = userDao.getAllUsers();
        } catch (SQLException throwables) {
            System.err.println("Не удалось получить userList");
            throwables.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {
        try {
            userDao.cleanUsersTable();
        } catch (SQLException throwables) {
            System.err.println("Не удалось очистить таблицу");
            throwables.printStackTrace();
        }
    }

}
