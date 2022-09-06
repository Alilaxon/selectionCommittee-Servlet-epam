package com.epam.selectioncommittee.model.dao.mapper;

import com.epam.selectioncommittee.model.builders.StatementBuilder;
import com.epam.selectioncommittee.model.entity.Statement;


import java.sql.ResultSet;
import java.sql.SQLException;

public class StatementMapper {

    public static Statement extractStatement(ResultSet resultSet) throws SQLException {

        return StatementBuilder.builder()
                .id(resultSet.getLong(Columns.ID))
                .facultyId(FacultyMapper.extractFaculty(resultSet,Columns.FACULTY_ID))
                .userId(UserMapper.extractUser(resultSet,Columns.USER_ID))
                .gradePointAverage(resultSet.getLong(Columns.GPA))
                .positionId(PositionMapper.extractPosition(resultSet,Columns.POSITION_ID))
                .build();
    }
}
