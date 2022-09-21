package com.epam.selectioncommittee.controller;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.controller.command.admin.GetAdminPage;
import com.epam.selectioncommittee.controller.command.admin.GetAllUsers;
import com.epam.selectioncommittee.controller.command.admin.PostBlockUsers;
import com.epam.selectioncommittee.controller.command.admin.PostCloseRecruitment;
import com.epam.selectioncommittee.controller.command.faculty.*;
import com.epam.selectioncommittee.controller.command.statement.GetCreateStatement;
import com.epam.selectioncommittee.controller.command.statement.GetStatements;
import com.epam.selectioncommittee.controller.command.statement.PostCreateStatement;
import com.epam.selectioncommittee.controller.command.statement.PostDeleteStatement;
import com.epam.selectioncommittee.controller.command.subject.GetAllSubjects;
import com.epam.selectioncommittee.controller.command.subject.GetCreateSubject;
import com.epam.selectioncommittee.controller.command.subject.PostCreateSubject;
import com.epam.selectioncommittee.controller.command.subject.PostDeleteSubject;
import com.epam.selectioncommittee.controller.command.user.*;
import com.epam.selectioncommittee.controller.util.url.*;
import com.epam.selectioncommittee.model.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontController extends HttpServlet {

    private static final Logger log = LogManager.getLogger(FrontController.class);
    private final Map<String, Command> getCommands = new HashMap<>();
    private final Map<String, Command> postCommands = new HashMap<>();

    private static final String COMMAND_NOT_FOUND = "Command not found";

    private static final String REDIRECT = "redirect:";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ServiceFactory factory = ServiceFactory.getInstance();

        setGetCommands(factory);
        setPostCommands(factory);

        log.info("initialization");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("Do GET Request ");

        process(req,resp,getCommands);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        log.info("Do POST Request ");


        process(req,resp,postCommands);
    }




    private void process(HttpServletRequest request, HttpServletResponse response, Map<String, Command> commandMap) throws ServletException, IOException {

        final String URI = request.getRequestURI();

        String commandKey = commandMap.keySet().stream()
                .filter(key -> key.equals(URI))
                .findFirst()
                .orElse(COMMAND_NOT_FOUND);

        if (commandKey.equals(COMMAND_NOT_FOUND)) {
//            logger.warn("page: {} not found", URI);
//            response.sendError(404);
            return;
        }

        Command command = commandMap.get(commandKey);
        String result = command.execute(request);

        renderPage(request, response, result);

    }

    private void renderPage(HttpServletRequest req, HttpServletResponse resp, String pagePath) throws ServletException, IOException {
        if (pagePath.startsWith(REDIRECT)) {
            resp.sendRedirect(pagePath.replace(REDIRECT, ""));
        } else {
            req.getRequestDispatcher(pagePath).forward(req, resp);
        }
    }

    private void setGetCommands(ServiceFactory serviceFactory) {
        // User GET commands

        getCommands.put(UserUrl.LOGIN,new GetLogin());
        getCommands.put(UserUrl.REGISTERED,new GetUserRegistered());
        getCommands.put(UserUrl.LOGOUT,new GetLogOut());

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
                        serviceFactory.createUserService(),serviceFactory.createStatementService()));
        getCommands.put(StatementUrl.STATEMENTS,
                new GetStatements(serviceFactory.createStatementService()));


    }

    private void setPostCommands(ServiceFactory serviceFactory) {

        // User POST commands
        postCommands.put(UserUrl.REGISTRATION,new PostCreateUser(serviceFactory.createUserService()));
        postCommands.put(UserUrl.LOGIN,new PostLogin(serviceFactory.createUserService()));

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
        postCommands.put(FacultyUrl.DELETE_FACULTY,
                new PostDeleteFaculty(serviceFactory.createFacultyService()));

        // Statement POST commands
        postCommands.put(StatementUrl.CREATE_STATEMENT,
                new PostCreateStatement(serviceFactory.createStatementService()));
        postCommands.put(StatementUrl.DELETE_STATEMENT,
                new PostDeleteStatement(serviceFactory.createStatementService()));
    }
}
