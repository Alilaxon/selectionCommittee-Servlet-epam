package com.epam.selectioncommittee.model.service;

import com.epam.selectioncommittee.model.dao.implementation.DaoFactory;
import com.epam.selectioncommittee.model.service.util.SHA256PasswordEncoder;

public class ServiceFactoryImpl extends ServiceFactory {
    @Override
    public UserService createUserService() {


        return new UserService(DaoFactory.getInstance().createUserRepository()
                , new SHA256PasswordEncoder()
                , DaoFactory.getInstance().createRoleRepository());
    }

    @Override
    public FacultyService createFacultyService() {
        return new FacultyService(DaoFactory.getInstance().createFacultyRepository()
                , DaoFactory.getInstance().createSubjectRepository());
    }

    @Override
    public SubjectService createSubjectService() {
        return new SubjectService(DaoFactory.getInstance().createSubjectRepository());
    }

    @Override
    public StatementService createStatementService() {
        return new StatementService(DaoFactory.getInstance().createStatementRepository()
                , DaoFactory.getInstance().createPositionRepository()
                ,DaoFactory.getInstance().createUserRepository()
                ,DaoFactory.getInstance().createFacultyRepository());
    }
}
