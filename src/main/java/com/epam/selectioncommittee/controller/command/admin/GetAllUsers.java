package com.epam.selectioncommittee.controller.command.admin;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class GetAllUsers implements Command {

    UserService userService;

    public GetAllUsers(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {


        request.setAttribute("users",userService.getAllUsers());
        //TODO
        return "jsp/admin/users.jsp";
    }
}
