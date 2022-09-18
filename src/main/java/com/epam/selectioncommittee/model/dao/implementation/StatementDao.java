package com.epam.selectioncommittee.model.dao.implementation;

import com.epam.selectioncommittee.model.dao.DBmanager.DBManager;
import com.epam.selectioncommittee.model.dao.StatementRepository;
import com.epam.selectioncommittee.model.dao.mapper.StatementMapper;
import com.epam.selectioncommittee.model.entity.Statement;
import com.epam.selectioncommittee.model.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatementDao implements StatementRepository {

    private static final Logger log = LogManager.getLogger(StatementDao.class);
    @Override
    public Statement save(Statement statement) {

        log.info("{}",statement.toString());

        try (Connection connection = DBManager.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO statements(faculty_id, user_id, gpa, position_id)" +
                            " VALUES (?,?,?,?)");
            preparedStatement.setLong(1, statement.getFacultyId().getId());
            preparedStatement.setLong(2, statement.getUserId().getId());
            preparedStatement.setLong(3,statement.getGradePointAverage());
            preparedStatement.setLong(4,1);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        log.info("statement was created");

        } catch (SQLException e) {

            log.warn("Catch SQLException");

            throw new RuntimeException(e);
        }
        return statement;
    }

    @Override
    public Statement update(Statement statement) {
        try (Connection connection = DBManager.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE statements SET position_id = ? WHERE id = ?");

            preparedStatement.setLong(1,statement.getPosition().getId());
            preparedStatement.setLong(2,statement.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return statement;
    }

    @Override
    public void deleteById(Long id) {

        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("DELETE FROM statements WHERE id =?");
            statement.setLong(1,id);
            statement.execute();
            statement.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Statement> findAllByUserId(User user) {

        List<Statement> statements = new ArrayList<>();

        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM statements\n" +
                    "    JOIN faculties f on f.id = statements.faculty_id\n" +
                    "    JOIN users u on u.id = statements.user_id\n" +
                    "    JOIN positions p on p.id = statements.position_id WHERE statements.user_id =?");
            statement.setLong(1,user.getId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                statements.add(StatementMapper.extractStatement(resultSet));
            }
            statement.close();
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
        return statements;
    }

    @Override
    public List<Statement> findAllByFacultyId(Long facultyId) {
        List<Statement> statements = new ArrayList<>();

        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM statements\n" +
                    "    JOIN faculties f on f.id = statements.faculty_id\n" +
                    "    JOIN users u on u.id = statements.user_id\n" +
                    "    JOIN positions p on p.id = statements.position_id WHERE statements.faculty_id =?");
            statement.setLong(1,facultyId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                statements.add(StatementMapper.extractStatement(resultSet));
            }
            statement.close();
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
        return statements;
    }



    @Override
    public boolean existsByUserIdAndAndFacultyId(Long userId, Long facultyId) {
        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM statements " +
                    "WHERE user_id =? AND faculty_id=?");
            statement.setLong(1,userId);
            statement.setLong(2,facultyId);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAll(List<Statement> statements) {

        for (Statement statement: statements) {

            deleteById(statement.getId());

        }

    }

    @Override
    public void updateAll(List<Statement> statements) {

        for (Statement statement: statements) {

            update(statement);

        }
    }
}
