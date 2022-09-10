package com.epam.selectioncommittee.model.dao;

import com.epam.selectioncommittee.model.dao.implementation.DaoFactory;

public abstract class Repository {

    private static volatile Repository repository;

    protected Repository(){}

    public abstract UserRepository createUserRepository();
    public abstract SubjectRepository createSubjectRepository();
    public abstract FacultyRepository createFacultyRepository();
    public abstract StatementRepository createStatementRepository();
    public abstract RoleRepository createRoleRepository();
    public abstract PositionRepository createPositionRepository();


    public static Repository getInstance() {
        if (repository == null) {
            synchronized (Repository.class) {
                if (repository == null) {
                    repository = new DaoFactory();
                }
            }
        }
        return repository;
    }

}
