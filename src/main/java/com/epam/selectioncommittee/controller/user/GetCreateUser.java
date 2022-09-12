package com.epam.selectioncommittee.controller.user;

import com.epam.selectioncommittee.controller.Command;
import com.epam.selectioncommittee.model.dto.UserForm;

import javax.servlet.http.HttpServletRequest;

public class GetCreateUser implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        request.setAttribute("userForm",new UserForm());

        return "jsp/registration.jsp";
    }

}
