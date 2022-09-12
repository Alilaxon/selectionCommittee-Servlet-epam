package com.epam.selectioncommittee.controller.admin;

import com.epam.selectioncommittee.controller.Command;
import com.epam.selectioncommittee.model.service.FacultyService;
import com.epam.selectioncommittee.model.service.StatementService;

import javax.servlet.http.HttpServletRequest;

public class PostCloseRecruitment implements Command {

    FacultyService facultyService;

    StatementService statementService;

    public PostCloseRecruitment(FacultyService facultyService, StatementService statementService) {
        this.facultyService = facultyService;
        this.statementService = statementService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        //TODO
        return null;
    }
}
