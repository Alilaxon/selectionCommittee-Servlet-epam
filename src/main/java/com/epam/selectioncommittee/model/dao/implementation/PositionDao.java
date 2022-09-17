package com.epam.selectioncommittee.model.dao.implementation;

import com.epam.selectioncommittee.model.dao.DBmanager.DBManager;
import com.epam.selectioncommittee.model.dao.PositionRepository;
import com.epam.selectioncommittee.model.dao.mapper.Columns;
import com.epam.selectioncommittee.model.dao.mapper.PositionMapper;
import com.epam.selectioncommittee.model.entity.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PositionDao implements PositionRepository {
    @Override
    public Position findByPositionType(Position.PositionType type) {

        Position position = null;

        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM positions WHERE position_name =?");
            statement.setString(1, type.name());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) position = PositionMapper.extractPosition(resultSet, Columns.ID);
            statement.close();

            return position;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
