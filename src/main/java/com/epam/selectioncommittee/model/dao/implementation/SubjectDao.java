package com.epam.selectioncommittee.model.dao.implementation;

import com.epam.selectioncommittee.model.dao.DBmanager.DBManager;
import com.epam.selectioncommittee.model.dao.SubjectRepository;
import com.epam.selectioncommittee.model.dao.mapper.SubjectMapper;
import com.epam.selectioncommittee.model.entity.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao implements SubjectRepository {
    @Override
    public Subject save(Subject subject) {

        System.out.println(subject.toString());
        try (Connection connection = DBManager.getInstance().getConnection()){
            PreparedStatement statement = connection
           .prepareStatement("INSERT INTO subjects(name_en, name_ru) VALUES (?,?)");

            statement.setString(1,subject.getNameEN());
            statement.setString(2,subject.getNameRU());
            statement.execute();
            statement.close();


        } catch (SQLException e) {

            System.out.println("catch SQLException");
            e.printStackTrace();
        }
        return subject;
    }

    @Override
    public List<Subject> findAll() {

        List<Subject> subjects = new ArrayList<>();

        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM subjects");
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



    @Override
    public boolean existsByNameEN(String name) {

        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM subjects WHERE name_en =?");
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();

           return resultSet.next();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Subject findById(Long id) {

        Subject subject= null;

        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM subjects WHERE id =?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                subject = SubjectMapper.extractSubject(resultSet);

            }
            statement.close();

            return subject;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean deleteById(Long id) {
        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("DELETE FROM subjects WHERE id =?");
            statement.setLong(1,id);
            statement.execute();
            statement.close();


        } catch (Exception e) {

            e.printStackTrace();
        }
       return true;
    }

   public List<Subject> findAllByFaculty(Long id){
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
