package com.epam.selectioncommittee.model.dao;

import com.epam.selectioncommittee.model.entity.Role;

public interface RoleRepository {

    Role findByRoleName(Role.RoleName roleName);
}
