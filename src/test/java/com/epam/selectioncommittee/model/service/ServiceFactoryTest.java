package com.epam.selectioncommittee.model.service;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class ServiceFactoryTest {


    @Test
    void createUserService() {
        assertEquals(UserService.class,ServiceFactory.getInstance().createUserService().getClass());
    }


    @Test
    void createFacultyService() {
        assertEquals(FacultyService.class,ServiceFactory.getInstance().createFacultyService().getClass());
    }

    @Test
    void createSubjectService() {
        assertEquals(SubjectService.class,ServiceFactory.getInstance().createSubjectService().getClass());
    }

    @Test
    void createStatementService() {
        assertEquals(StatementService.class,ServiceFactory.getInstance().createStatementService().getClass());
    }
}