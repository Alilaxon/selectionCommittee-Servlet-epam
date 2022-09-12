package com.epam.selectioncommittee.controller.admin;

import com.epam.selectioncommittee.controller.Command;
import com.epam.selectioncommittee.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class GetAllUsers implements Command {

    UserService userService;

    public GetAllUsers(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        //TODO
        return null;
    }
}
