package com.epam.selectioncommittee.controller.faculty;

import com.epam.selectioncommittee.controller.Command;
import com.epam.selectioncommittee.model.dto.FacultyForm;
import com.epam.selectioncommittee.model.service.SubjectService;

import javax.servlet.http.HttpServletRequest;

public class GetCreateFaculty implements Command {

    SubjectService subjectService;

    public GetCreateFaculty(SubjectService subjectService) {

        this.subjectService = subjectService;
    }

    @Override
    public String execute(HttpServletRequest request) {



        request.setAttribute("subjectList", subjectService.getAllSubjects());
        request.setAttribute("facultyForm", new FacultyForm());
        return "jsp/admin/createFaculty.jsp";
    }
}
