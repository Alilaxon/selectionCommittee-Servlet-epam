package com.epam.selectioncommittee.controller.admin;

import com.epam.selectioncommittee.controller.Command;
import com.epam.selectioncommittee.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class GetAdminPage implements Command {

    UserService userService;

    public GetAdminPage(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        //TODO
        return null;
    }
}
