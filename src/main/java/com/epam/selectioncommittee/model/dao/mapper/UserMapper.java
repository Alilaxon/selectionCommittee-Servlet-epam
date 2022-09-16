package com.epam.selectioncommittee.model.dao.mapper;
import com.epam.selectioncommittee.model.builders.UserBuilder;
import com.epam.selectioncommittee.model.entity.Role;
import com.epam.selectioncommittee.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
    public static User extractUser(ResultSet resultSet, String id) throws SQLException {

        return UserBuilder.builder()
                .id(resultSet.getLong(id))
                .username(resultSet.getString(Columns.USERNAME))
                .email(resultSet.getString(Columns.EMAIL))
                .firstname(resultSet.getString(Columns.FIRSTNAME))
                .surname(resultSet.getString(Columns.SURNAME))
                .city(resultSet.getString(Columns.CITY))
                .region(resultSet.getString(Columns.REGION))
                .institution(resultSet.getString(Columns.INSTITUTION))
                .blocked(resultSet.getBoolean(Columns.BLOCKED))
                .role(new Role(1L, Role.RoleName.USER))
                .build();
    }
}
