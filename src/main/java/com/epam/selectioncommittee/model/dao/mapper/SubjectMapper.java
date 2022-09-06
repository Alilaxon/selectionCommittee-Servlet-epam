package com.epam.selectioncommittee.model.dao.mapper;

import com.epam.selectioncommittee.model.builders.SubjectBuilder;
import com.epam.selectioncommittee.model.entity.Subject;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectMapper {

    public static Subject extractSubject(ResultSet resultSet ) throws SQLException {

        return SubjectBuilder.builder()
                .id(resultSet.getLong(Columns.ID))
                .nameEN(resultSet.getString(Columns.NAME_EN))
                .nameRU(resultSet.getString(Columns.NAME_RU))
                .build();
    }
}
