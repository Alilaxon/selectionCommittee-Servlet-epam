package com.epam.selectioncommittee.controller.command.user;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.entity.User;
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

        Long userId = Long.parseLong(request.getParameter("userId"));
        User user = userService.findUserById(userId);


        request.setAttribute("statements",statementService.findAllStatementsByUserId(user));
        //TODO

        return "jsp/user/userInfo.jsp";
    }
}
