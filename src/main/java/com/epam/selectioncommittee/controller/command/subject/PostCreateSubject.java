package com.epam.selectioncommittee.controller.command.subject;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.service.SubjectService;

import javax.servlet.http.HttpServletRequest;

public class PostCreateSubject implements Command {

    SubjectService subjectService;

    public PostCreateSubject(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        //TODO
        return null;
    }
}
