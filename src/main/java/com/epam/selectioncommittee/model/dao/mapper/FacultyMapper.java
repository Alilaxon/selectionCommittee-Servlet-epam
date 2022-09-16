package com.epam.selectioncommittee.model.dao.mapper;
import com.epam.selectioncommittee.model.builders.FacultyBuilder;
import com.epam.selectioncommittee.model.entity.Faculty;
import com.epam.selectioncommittee.model.entity.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FacultyMapper {

    public static Faculty extractFaculty(ResultSet resultSet ,String id) throws SQLException {

        return FacultyBuilder.builder()
                .id(resultSet.getLong(id))
                .facultyName(resultSet.getString(Columns.NAME))
                .facultyNameRU(resultSet.getString(Columns.NAME_RU))
                .budgetPlaces(resultSet.getInt(Columns.BUDGET_PLACES))
                .generalPlaces(resultSet.getInt(Columns.GENERAL_PLACES))
                .recruitment(resultSet.getBoolean(Columns.RECRUITMENT))
                .build();
    }

    public static Faculty extractFaculty(ResultSet resultSet , String id, List<Subject> subjects) throws SQLException {


        return FacultyBuilder.builder()
                .id(resultSet.getLong(id))
                .facultyName(resultSet.getString(Columns.NAME))
                .facultyNameRU(resultSet.getString(Columns.NAME_RU))
                .budgetPlaces(resultSet.getInt(Columns.BUDGET_PLACES))
                .generalPlaces(resultSet.getInt(Columns.GENERAL_PLACES))
                .requiredSubjects(subjects)
                .recruitment(resultSet.getBoolean(Columns.RECRUITMENT))
                .build();
    }
}
