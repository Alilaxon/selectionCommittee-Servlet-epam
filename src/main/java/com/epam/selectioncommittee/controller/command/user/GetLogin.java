package com.epam.selectioncommittee.controller.command.user;

import com.epam.selectioncommittee.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class GetLogin implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        System.out.println("login");
        return  "jsp/login.jsp";
    }
}
