package com.epam.selectioncommittee.controller.mapper;

import com.epam.selectioncommittee.model.builders.UserFormBuilder;
import com.epam.selectioncommittee.model.dto.UserForm;

import javax.servlet.http.HttpServletRequest;

public class UserFormMapper {

    public static UserForm mapper(HttpServletRequest request){

        return UserFormBuilder.builder()
                .username(request.getParameter("username"))
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .firstname(request.getParameter("firstname"))
                .surname(request.getParameter("username"))
                .city(request.getParameter("city"))
                .region(request.getParameter("region"))
                .institution(request.getParameter("institution"))
                .build();
    }
}
