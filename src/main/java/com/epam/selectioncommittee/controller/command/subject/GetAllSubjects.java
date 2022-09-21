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


        String page = (request.getParameter("page"));

        if(page == null) page = "1";

        int pages = subjectService.getPages();

        request.setAttribute("pages",pages);
        request.setAttribute("page",page);

        request.setAttribute("subjects",subjectService.getAllSubjectsPage(Integer.parseInt(page)));

        return "/jsp/admin/subjects.jsp";
    }
}
