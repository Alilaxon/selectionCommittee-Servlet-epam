package com.epam.selectioncommittee.model.dao.implementation;

import com.epam.selectioncommittee.model.dao.*;

public class DaoFactory extends Repository {
    @Override
    public UserRepository createUserRepository() {
        return new UserDao();
    }

    @Override
    public SubjectRepository createSubjectRepository() {
        return new SubjectDao();
    }

    @Override
    public FacultyRepository createFacultyRepository() {
        return new FacultyDao();
    }

    @Override
    public StatementRepository createStatementRepository() {
        return new StatementDao();
    }

    @Override
    public RoleRepository createRoleRepository() {
        return new RoleDao();
    }

    @Override
    public PositionRepository createPositionRepository() {
        return new PositionDao();
    }
}
