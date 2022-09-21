package com.epam.selectioncommittee.model.dao.implementation;

import com.epam.selectioncommittee.model.dao.DBmanager.DBManager;
import com.epam.selectioncommittee.model.dao.RoleRepository;
import com.epam.selectioncommittee.model.dao.mapper.Columns;
import com.epam.selectioncommittee.model.dao.mapper.RoleMapper;
import com.epam.selectioncommittee.model.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoleDao implements RoleRepository {
    @Override
    public Role findByRoleName(Role.RoleName roleName) {
        Role role = null;
        try(Connection connection = DBManager.getInstance().getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM roles WHERE role_name =?");
            statement.setString(1, roleName.name());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) role = RoleMapper.extractRole(resultSet, Columns.ID);
            statement.close();
            resultSet.close();

            return role;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
