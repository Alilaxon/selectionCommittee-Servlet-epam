package com.epam.selectioncommittee.controller.command.subject;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.controller.command.statement.GetCreateStatement;
import com.epam.selectioncommittee.controller.mapper.SubjectFormMapper;
import com.epam.selectioncommittee.model.dto.SubjectForm;
import com.epam.selectioncommittee.model.exception.SubjectIsReservedException;
import com.epam.selectioncommittee.model.service.SubjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class PostCreateSubject implements Command {

    private static final Logger log = LogManager.getLogger(GetCreateStatement.class);

    SubjectService subjectService;

    public PostCreateSubject(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        SubjectForm subjectForm = SubjectFormMapper.mapper(request);

        log.info("temp ms check nameRU {}",subjectForm.getNameRU());

        try {
            subjectService.createSubject(subjectForm);

        } catch (SubjectIsReservedException e) {

            return "/jsp/admin/createSubject.jsp";
        }

        return "redirect:/admin/subjects";
    }
}
