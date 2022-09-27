package com.epam.selectioncommittee.controller.mapper;

import com.epam.selectioncommittee.model.builders.SubjectFormBuilder;
import com.epam.selectioncommittee.model.dto.SubjectForm;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

public class SubjectFormMapper {

    public static SubjectForm mapper (HttpServletRequest request){
        return SubjectFormBuilder.builder()
                .nameEN(request.getParameter("nameEN"))
                .nameRU(new String(request.getParameter("nameRU").getBytes(StandardCharsets.ISO_8859_1),
                        StandardCharsets.UTF_8))
                .build();
    }
}
