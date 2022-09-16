package com.epam.selectioncommittee.controller.command.admin;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class PostBlockUsers implements Command {

    UserService userService;

    public PostBlockUsers(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        //TODO
        return null;
    }
}
