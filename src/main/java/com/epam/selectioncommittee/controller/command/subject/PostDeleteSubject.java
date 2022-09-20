package com.epam.selectioncommittee.controller.command.subject;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.dao.mapper.Columns;
import com.epam.selectioncommittee.model.service.SubjectService;

import javax.servlet.http.HttpServletRequest;

public class PostDeleteSubject implements Command {

    SubjectService subjectService;

    public PostDeleteSubject(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        subjectService.deleteSubject(Long.valueOf(request.getParameter(Columns.ID)));

        return "redirect:/admin/subjects";
    }
}
