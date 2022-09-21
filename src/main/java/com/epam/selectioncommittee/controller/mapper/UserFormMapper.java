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
                .passwordCopy(request.getParameter("passwordCopy"))
                .firstname(request.getParameter("firstname"))
                .surname(request.getParameter("surname"))
                .city(request.getParameter("city"))
                .region(request.getParameter("region"))
                .institution(request.getParameter("institution"))
                .build();
    }

    public static void request (UserForm userForm ,HttpServletRequest request){
        request.setAttribute("username",userForm.getUsername());
        request.setAttribute("email",userForm.getEmail());
        request.setAttribute("firstname",userForm.getFirstname());
        request.setAttribute("surname",userForm.getSurname());
        request.setAttribute("city",userForm.getCity());
        request.setAttribute("region",userForm.getRegion());
        request.setAttribute("institution",userForm.getInstitution());

    }
}
