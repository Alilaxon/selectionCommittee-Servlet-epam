package com.epam.selectioncommittee.controller.command.statement;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.entity.Faculty;
import com.epam.selectioncommittee.model.service.FacultyService;
import com.epam.selectioncommittee.model.service.StatementService;
import com.epam.selectioncommittee.model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class GetCreateStatement implements Command {

    private static final Logger log = LogManager.getLogger(GetCreateStatement.class);

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
       Long userId = Long.parseLong(request.getParameter("userId"));

        Faculty faculty = facultyService.getFaculty(facultyId);


        if (statementService.isRegistered(userId, facultyId)) {

            log.info("User id={} already registered on this faculty",userId);

            return "/jsp/user/alreadyRegistered.jsp";
        }


       request.setAttribute("faculty",faculty);
       request.setAttribute("subjectList", faculty.getRequiredSubjects());
        //TODO
        return "/jsp/user/createStatement.jsp";
    }
}
