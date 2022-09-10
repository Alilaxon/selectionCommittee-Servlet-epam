package com.epam.selectioncommittee.model.service;



public abstract class ServiceFactory {
    private static volatile ServiceFactory serviceFactory;

    protected ServiceFactory() {}

    public abstract UserService createUserService();
    public abstract FacultyService createFacultyService();
    public abstract SubjectService createSubjectService();
    public abstract StatementService createStatementService();

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            synchronized (ServiceFactory.class) {
                if (serviceFactory == null) {
                    serviceFactory = new ServiceFactoryImpl();
                }
            }
        }
        return serviceFactory;
    }
}
