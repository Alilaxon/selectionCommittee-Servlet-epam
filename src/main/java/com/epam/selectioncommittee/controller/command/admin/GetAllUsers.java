package com.epam.selectioncommittee.controller.command.admin;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class GetAllUsers implements Command {

    private static final Logger log = LogManager.getLogger(GetAllUsers.class);

    UserService userService;

    public GetAllUsers(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        log.info("Admin get all users");


        request.setAttribute("users",userService.getAllUsers());
        //TODO
        return "/jsp/admin/users.jsp";
    }
}
