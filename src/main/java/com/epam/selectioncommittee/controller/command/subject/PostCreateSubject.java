package com.epam.selectioncommittee.controller.command.subject;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.controller.mapper.SubjectFormMapper;
import com.epam.selectioncommittee.model.dto.SubjectForm;
import com.epam.selectioncommittee.model.exception.SubjectIsReservedException;
import com.epam.selectioncommittee.model.service.SubjectService;

import javax.servlet.http.HttpServletRequest;

public class PostCreateSubject implements Command {

    SubjectService subjectService;

    public PostCreateSubject(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        SubjectForm subjectForm = SubjectFormMapper.mapper(request);

        try {
            subjectService.createSubject(subjectForm);

        } catch (SubjectIsReservedException e) {

            return "/jsp/admin/createSubject.jsp";
        }

        return "redirect:/admin/subjects";
    }
}
