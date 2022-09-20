package com.epam.selectioncommittee.controller.command.user;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.entity.User;
import com.epam.selectioncommittee.model.exception.AuthenticationException;
import com.epam.selectioncommittee.model.exception.UserIsBlockedException;
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
            request.getSession().setAttribute("username",user.getUsername());
            request.getSession().setAttribute("role",user.getRole().getRoleName().name());

        log.info("User = {} get  Role = {}",login,user.getRole().getRoleName().name());
        } catch (AuthenticationException e) {

            return "jsp/login.jsp";
        } catch (UserIsBlockedException e) {

            return "jsp/user/userIsBlocked.jsp";
        }
        return "redirect:/";
    }
}
