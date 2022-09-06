package com.epam.selectioncommittee.model.dao.implementation;
import com.epam.selectioncommittee.model.dao.DBmanager.DBManager;
import com.epam.selectioncommittee.model.dao.UserRepository;
import com.epam.selectioncommittee.model.dao.mapper.Columns;
import com.epam.selectioncommittee.model.dao.mapper.UserMapper;
import com.epam.selectioncommittee.model.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements UserRepository {
    @Override
    public User save(User user) {
        return null;
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
            statement.close();

            return UserMapper.extractUser(resultSet,Columns.ID);

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
