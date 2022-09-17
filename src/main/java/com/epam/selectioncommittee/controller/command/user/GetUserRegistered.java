package com.epam.selectioncommittee.controller.command.user;

import com.epam.selectioncommittee.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class GetUserRegistered implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "jsp/registered.jsp";
    }
}
