package com.epam.selectioncommittee.controller.command.statement;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.entity.Faculty;
import com.epam.selectioncommittee.model.entity.User;
import com.epam.selectioncommittee.model.service.FacultyService;
import com.epam.selectioncommittee.model.service.StatementService;
import com.epam.selectioncommittee.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class GetCreateStatement implements Command {

    FacultyService facultyService;

    UserService userService;


     StatementService statementService;

    public GetCreateStatement(FacultyService facultyService,
                              UserService userService,
                              StatementService statementService) {
        this.facultyService = facultyService;
        this.userService = userService;
        this.statementService = statementService;
    }

    @Override
    public String execute(HttpServletRequest request) {
       Long facultyId = Long.parseLong(request.getParameter("facultyId"));

        Faculty faculty = facultyService.getFaculty(facultyId);
       User user = userService.findUserById(1l);

       request.setAttribute("faculty",faculty);
       request.setAttribute("subjectList", faculty.getRequiredSubjects());
        //TODO
        return "user/createStatement.jsp";
    }
}
