package com.epam.selectioncommittee.model.dao.implementation;

import com.epam.selectioncommittee.model.dao.DBmanager.DBManager;
import com.epam.selectioncommittee.model.dao.UserRepository;
import com.epam.selectioncommittee.model.dao.mapper.Columns;
import com.epam.selectioncommittee.model.dao.mapper.UserMapper;
import com.epam.selectioncommittee.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements UserRepository {
    @Override
    public User save(User user) {
        try (Connection connection = DBManager.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users(username, email, password," +
                            " firstname, surname, city, region," +
                            " institution, role_id) VALUES (?,?,?,?,?,?,?,?,?)");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getFirstname());
            statement.setString(5, user.getSurname());
            statement.setString(6, user.getCity());
            statement.setString(7, user.getRegion());
            statement.setString(8, user.getInstitution());
            statement.setLong(9, user.getRole().getId());
            statement.execute();

            statement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User update(User user) {

        try (Connection connection = DBManager.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE users SET blocked = ? WHERE id = ?");

            statement.setBoolean(1, user.getBlocked());
            statement.setLong(2, user.getId());
            statement.execute();
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        @Override
    public boolean existsByUsername(String name) {

        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username =?");
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsByEmail(String email) {

        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email =?");
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {

        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username =? AND password=?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            statement.close();

            return UserMapper.extractUser(resultSet,Columns.ID);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public User findByUsername(String username) {

        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username =?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            statement.close();

            return UserMapper.extractUser(resultSet,Columns.ID);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public User findById(Long id) {
        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id =?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            User user = null;
            while (resultSet.next()) user = UserMapper.extractUser(resultSet,Columns.ID);
            statement.close();

            return user;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAllByRole() {
        List<User> users = new ArrayList<>();

        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE role_id=1");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                users.add(UserMapper.extractUser(resultSet, Columns.ID));
            }
            statement.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
