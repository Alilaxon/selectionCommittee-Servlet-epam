package com.epam.selectioncommittee.model.dao.mapper;

import com.epam.selectioncommittee.model.entity.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper {

    public static Role extractRole(ResultSet resultSet , String id) throws SQLException {

        return new Role(resultSet.getLong(id),Role.RoleName.valueOf(resultSet.getString(Columns.ROLE_NAME)));
    }
}
