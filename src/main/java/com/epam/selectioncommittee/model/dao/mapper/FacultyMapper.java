package com.epam.selectioncommittee.model.dao.mapper;
import com.epam.selectioncommittee.model.builders.FacultyBuilder;
import com.epam.selectioncommittee.model.entity.Faculty;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyMapper {

    public static Faculty extractFaculty(ResultSet resultSet ,String id) throws SQLException {

        return FacultyBuilder.builder()
                .id(resultSet.getLong(id))
                .facultyName(resultSet.getString(Columns.NAME))
                .facultyNameRU(resultSet.getString(Columns.NAME_EN))
                .budgetPlaces(resultSet.getInt(Columns.BUDGET_PLACES))
                .generalPlaces(resultSet.getInt(Columns.GENERAL_PLACES))
                .recruitment(resultSet.getBoolean(Columns.RECRUITMENT))
                .build();
    }
}
