package com.epam.selectioncommittee.controller.subject;

import com.epam.selectioncommittee.controller.Command;
import com.epam.selectioncommittee.model.service.SubjectService;

import javax.servlet.http.HttpServletRequest;

public class GetCreateSubject implements Command {

    SubjectService subjectService;

    public GetCreateSubject(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        //TODO
        return null;
    }
}
