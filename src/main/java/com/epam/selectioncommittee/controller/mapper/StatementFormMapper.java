package com.epam.selectioncommittee.controller.mapper;

import com.epam.selectioncommittee.model.builders.StatementFormBuilder;
import com.epam.selectioncommittee.model.dto.StatementForm;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class StatementFormMapper {

    public static StatementForm mapper(HttpServletRequest request){

        return StatementFormBuilder.builder()
                .user(request.getParameter("userId"))
                .faculty(request.getParameter("facultyid"))
                .grades(Arrays.asList(request.getParameterValues("grades")))
                .build();

    }



}
