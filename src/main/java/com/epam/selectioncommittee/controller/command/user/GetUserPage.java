package com.epam.selectioncommittee.controller.command.user;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.service.StatementService;
import com.epam.selectioncommittee.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class GetUserPage implements Command {

    UserService userService;

    StatementService statementService;

    public GetUserPage(UserService userService, StatementService statementService) {
        this.userService = userService;
        this.statementService = statementService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        //TODO

        return null;
    }
}
