package com.epam.selectioncommittee.controller.command.admin;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.service.FacultyService;
import com.epam.selectioncommittee.model.service.StatementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class PostCloseRecruitment implements Command {

    private static final Logger log = LogManager.getLogger(PostCloseRecruitment.class);

    FacultyService facultyService;

    StatementService statementService;

    public PostCloseRecruitment(FacultyService facultyService, StatementService statementService) {
        this.facultyService = facultyService;
        this.statementService = statementService;
    }

    @Override
    public String execute(HttpServletRequest request) {
       long facultyId = Long.parseLong(request.getParameter("facultyId"));
       boolean recruit = Boolean.parseBoolean((request.getParameter("facultyOpen")));

       log.info("faculty id = {} , status {}",facultyId,recruit);

        if (recruit) {
            facultyService.openFacultyById(facultyId);
        } else {
            facultyService.closeFacultyById(facultyId);
            statementService.finalizeStatements(facultyService.getFaculty(facultyId));

        }
        return "redirect:/faculties";
    }
}
