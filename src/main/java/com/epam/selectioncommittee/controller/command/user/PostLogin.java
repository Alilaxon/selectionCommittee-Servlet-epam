package com.epam.selectioncommittee.controller.command.user;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.entity.User;
import com.epam.selectioncommittee.model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class PostLogin implements Command {

    private static final Logger log = LogManager.getLogger(PostLogin.class);

    UserService userService;

    private static final String LOGIN = "username";
    private static final String PASSWORD = "password";


    public PostLogin(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);



        try {

            User user = userService.Authentication(login,password);
            request.getSession().setAttribute("user",user);
            request.getSession().setAttribute("userId",user.getId());
            request.getSession().setAttribute("role",user.getRole().getRoleName().name());

        log.info("User = {} enter in system by Role {}",login,user.getRole().getRoleName().name());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/";
    }
}
