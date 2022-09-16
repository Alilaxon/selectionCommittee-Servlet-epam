package com.epam.selectioncommittee.model.dao.implementation;

import com.epam.selectioncommittee.model.dao.DBmanager.DBManager;
import com.epam.selectioncommittee.model.dao.FacultyRepository;
import com.epam.selectioncommittee.model.dao.mapper.Columns;
import com.epam.selectioncommittee.model.dao.mapper.FacultyMapper;
import com.epam.selectioncommittee.model.dao.mapper.SubjectMapper;
import com.epam.selectioncommittee.model.entity.Faculty;
import com.epam.selectioncommittee.model.entity.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacultyDao implements FacultyRepository {
    @Override
    public Faculty save(Faculty faculty) {
        try (Connection connection = DBManager.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO faculties (name, name_ru, budget_places, general_places,recruitment)" +
                            " VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            connection.setAutoCommit(false);
            statement.setString(1, faculty.getFacultyName());
            statement.setString(2, faculty.getFacultyNameRU());
            statement.setInt(3,faculty.getBudgetPlaces());
            statement.setInt(4,faculty.getGeneralPlaces());
            statement.setBoolean(5,faculty.getRecruitment());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating faculty failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    faculty.setId(generatedKeys.getLong(1));
                    System.out.println(faculty.getId());
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            PreparedStatement manyToMany = connection.prepareStatement
                    ("INSERT INTO faculties_subjects(faculty_id, subject_id) VALUES(?,?) ");

            for (Subject subject: faculty.getRequiredSubjects()) {
                manyToMany.setLong(1,faculty.getId());
                manyToMany.setLong(2,subject.getId());
                manyToMany.execute();
            }
            connection.commit();
            connection.setAutoCommit(true);
            statement.close();
            manyToMany.close();
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
        Faculty faculty = null;
        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM faculties WHERE id =?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) faculty = FacultyMapper.extractFaculty(resultSet, Columns.ID);
            statement.close();

            return faculty;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Faculty> findAll() {

        List<Faculty> facultyList = new ArrayList<>();

        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM faculties");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                facultyList.add(FacultyMapper.extractFaculty(resultSet,
                        Columns.ID,findAllSubjectsByFaculty(resultSet.getLong(Columns.ID))));
            }
            statement.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return facultyList;
    }

    @Override
    public void deleteById(Long id) {

        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("DELETE FROM faculties WHERE id =?");
            statement.setLong(1,id);
            statement.execute();
            statement.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private List<Subject> findAllSubjectsByFaculty(Long id){
        List<Subject> subjects = new ArrayList<>();

        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM subjects " +
                    "INNER JOIN faculties_subjects fs on subjects.id = fs.subject_id " +
                    "WHERE  faculty_id =?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                subjects.add(SubjectMapper.extractSubject(resultSet));
            }
            statement.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return subjects;
    }
}
