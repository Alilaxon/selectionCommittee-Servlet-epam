package com.epam.selectioncommittee.controller.mapper;

import com.epam.selectioncommittee.model.builders.SubjectFormBuilder;
import com.epam.selectioncommittee.model.dto.SubjectForm;

import javax.servlet.http.HttpServletRequest;

public class SubjectFormMapper {

    public SubjectForm mapper (HttpServletRequest request){
        return SubjectFormBuilder.builder()
                .nameEN(request.getParameter("nameEN"))
                .nameRU(request.getParameter("nameRU"))
                .build();
    }
}
