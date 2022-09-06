package com.epam.selectioncommittee.model.dao.implementation;

import com.epam.selectioncommittee.model.dao.DBmanager.DBManager;
import com.epam.selectioncommittee.model.dao.RoleRepository;
import com.epam.selectioncommittee.model.dao.mapper.Columns;
import com.epam.selectioncommittee.model.dao.mapper.RoleMapper;
import com.epam.selectioncommittee.model.dao.mapper.UserMapper;
import com.epam.selectioncommittee.model.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoleDao implements RoleRepository {
    @Override
    public Role findByRoleName(Role.RoleName roleName) {
        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM roles WHERE name =?");
            statement.setString(1, roleName.name());
            ResultSet resultSet = statement.executeQuery();
            statement.close();

            return RoleMapper.extractPosition(resultSet, Columns.ID);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
