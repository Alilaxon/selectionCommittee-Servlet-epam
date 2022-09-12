package com.epam.selectioncommittee.controller;

import com.epam.selectioncommittee.controller.admin.GetAdminPage;
import com.epam.selectioncommittee.controller.admin.GetAllUsers;
import com.epam.selectioncommittee.controller.admin.PostBlockUsers;
import com.epam.selectioncommittee.controller.admin.PostCloseRecruitment;
import com.epam.selectioncommittee.controller.faculty.*;
import com.epam.selectioncommittee.controller.statement.GetCreateStatement;
import com.epam.selectioncommittee.controller.statement.GetStatements;
import com.epam.selectioncommittee.controller.statement.PostCreateStatement;
import com.epam.selectioncommittee.controller.statement.PostDeleteStatement;
import com.epam.selectioncommittee.controller.subject.GetAllSubjects;
import com.epam.selectioncommittee.controller.subject.GetCreateSubject;
import com.epam.selectioncommittee.controller.subject.PostCreateSubject;
import com.epam.selectioncommittee.controller.subject.PostDeleteSubject;
import com.epam.selectioncommittee.controller.user.GetCreateUser;
import com.epam.selectioncommittee.controller.user.GetUserPage;
import com.epam.selectioncommittee.controller.user.PostCreateUser;
import com.epam.selectioncommittee.controller.util.url.*;
import com.epam.selectioncommittee.model.service.ServiceFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontController extends HttpServlet {

    private Map<String, Command> getCommands = new HashMap<>();
    private Map<String, Command> postCommands = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ServiceFactory factory = ServiceFactory.getInstance();

        setGetCommands(factory);
        setGetCommands(factory);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response, Map<String, Command> commandMap) {

    }

    private void setGetCommands(ServiceFactory serviceFactory) {
        // User GET commands

        getCommands.put(UserUrl.USER,
                new GetUserPage(serviceFactory.createUserService(),
                        serviceFactory.createStatementService()));
        getCommands.put(UserUrl.REGISTRATION,new GetCreateUser());

        // admin GET commands

        getCommands.put(AdminUrl.ADMIN_PAGE,
                new GetAdminPage(serviceFactory.createUserService()));
        getCommands.put(AdminUrl.USERS,
                new GetAllUsers(serviceFactory.createUserService()));


        // Subject GET commands
        getCommands.put(SubjectUrl.SUBJECTS,
                new GetAllSubjects(serviceFactory.createSubjectService()));
        getCommands.put(SubjectUrl.CREATE_SUBJECT,
                new GetCreateSubject(serviceFactory.createSubjectService()));

        // Faculty GET commands
        getCommands.put(FacultyUrl.FACULTIES,
                new GetAllFaculties(serviceFactory.createFacultyService()));
        getCommands.put(FacultyUrl.CREATE_FACULTY,
                new GetCreateFaculty(serviceFactory.createSubjectService()));
        getCommands.put(FacultyUrl.UPDATE_FACULTY,
                new GetUpdateFaculty(serviceFactory.createFacultyService(),
                        serviceFactory.createSubjectService()));

        // Statement GET commands
        getCommands.put(StatementUrl.CREATE_STATEMENT,
                new GetCreateStatement(serviceFactory.createFacultyService(),
                        serviceFactory.createUserService()));
        getCommands.put(StatementUrl.STATEMENTS,
                new GetStatements(serviceFactory.createStatementService()));


    }

    private void setPostCommands(ServiceFactory serviceFactory) {

        // User POST commands
        postCommands.put(UserUrl.REGISTRATION,new PostCreateUser(serviceFactory.createUserService()));
        // Admin POST commands
        postCommands.put(AdminUrl.BLOCK_USER,
                new PostBlockUsers(serviceFactory.createUserService()));
        postCommands.put(AdminUrl.CLOSE_RECRUITMENT,
                new PostCloseRecruitment(serviceFactory.createFacultyService(),
                        serviceFactory.createStatementService()));
        // Subject POST commands
        postCommands.put(SubjectUrl.CREATE_SUBJECT,
                new PostCreateSubject(serviceFactory.createSubjectService()));
        postCommands.put(SubjectUrl.DELETE_SUBJECT,
                new PostDeleteSubject(serviceFactory.createSubjectService()));

        // Faculty POST commands
        postCommands.put(FacultyUrl.CREATE_FACULTY,
                new PostCreateFaculty(serviceFactory.createFacultyService(),
                        serviceFactory.createSubjectService()));
        postCommands.put(FacultyUrl.UPDATE_FACULTY,
                new PostUpdateFaculty(serviceFactory.createSubjectService(),
                        serviceFactory.createFacultyService()));
        postCommands.put(SubjectUrl.DELETE_SUBJECT,
                new PostDeleteSubject(serviceFactory.createSubjectService()));

        // Statement POST commands
        postCommands.put(StatementUrl.CREATE_STATEMENT,
                new PostCreateStatement(serviceFactory.createStatementService()));
        postCommands.put(StatementUrl.DELETE_STATEMENT,
                new PostDeleteStatement(serviceFactory.createStatementService()));
    }
}


