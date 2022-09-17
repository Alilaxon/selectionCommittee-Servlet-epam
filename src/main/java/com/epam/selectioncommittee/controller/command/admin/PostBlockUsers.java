package com.epam.selectioncommittee.controller.command.admin;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class PostBlockUsers implements Command {

    private static final Logger log = LogManager.getLogger(PostBlockUsers.class);
    UserService userService;

    public PostBlockUsers(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        Long userId = Long.parseLong(request.getParameter("userId"));
        boolean blocked = Boolean.parseBoolean(request.getParameter("userBlocked"));

        log.info("User id={} was blocked = {}",userId,blocked);

        if (blocked) {
            userService.unblockUserById(userId);
        } else {
            userService.blockUserById(userId);
        }
        return "redirect:/users";
    }
}
