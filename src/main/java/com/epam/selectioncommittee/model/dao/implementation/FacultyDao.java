package com.epam.selectioncommittee.model.dao.implementation;

import com.epam.selectioncommittee.model.dao.DBmanager.DBManager;
import com.epam.selectioncommittee.model.dao.FacultyRepository;
import com.epam.selectioncommittee.model.dao.mapper.Columns;
import com.epam.selectioncommittee.model.dao.mapper.FacultyMapper;
import com.epam.selectioncommittee.model.entity.Faculty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FacultyDao implements FacultyRepository {
    @Override
    public Faculty save(Faculty faculty) {
        try (Connection connection = DBManager.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO faculties (name, name_ru, budget_places, general_places,recruitment)" +
                            " VALUES (?,?,?,?,?)");
            statement.setString(1, faculty.getFacultyName());
            statement.setString(2, faculty.getFacultyNameRU());
            statement.setInt(3,faculty.getBudgetPlaces());
            statement.setInt(4,faculty.getGeneralPlaces());
            statement.setBoolean(5,faculty.getRecruitment());
            statement.executeQuery();
            statement.close();
            return faculty;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsByName(String name) {

        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM faculties WHERE name =?");
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            statement.close();

            return resultSet.next();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Faculty findByName(String name) {

        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM faculties WHERE name =?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            statement.close();

            return FacultyMapper.extractFaculty(resultSet, Columns.ID);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Faculty findById(Long id) {
        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM faculties WHERE id =?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            statement.close();

            return FacultyMapper.extractFaculty(resultSet, Columns.ID);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Faculty> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("DELETE FROM faculties WHERE id =?");
            statement.setLong(1,id);
            statement.executeQuery();
            statement.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
