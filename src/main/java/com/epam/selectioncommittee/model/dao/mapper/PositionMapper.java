package com.epam.selectioncommittee.model.dao.mapper;


import com.epam.selectioncommittee.model.entity.Position;


import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionMapper {

    public static Position extractPosition(ResultSet resultSet ,String id) throws SQLException {

        return new Position(resultSet.getLong(id),Position.PositionType.valueOf(resultSet.getString(Columns.POSITION_NAME)));
    }
}
