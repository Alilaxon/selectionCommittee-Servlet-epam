package com.epam.selectioncommittee.controller.command.subject;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.service.SubjectService;

import javax.servlet.http.HttpServletRequest;

public class GetAllSubjects implements Command {

    SubjectService subjectService;

    public GetAllSubjects(SubjectService subjectService) {

        this.subjectService = subjectService;
    }

    @Override
    public String execute(HttpServletRequest request) {




        request.setAttribute("subjects",subjectService.getAllSubjects());
        //TODO
        return "jsp/admin/subjects.jsp";
    }
}
