package com.epam.selectioncommittee.controller.command.user;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.entity.Role;

import javax.servlet.http.HttpServletRequest;

import static com.epam.selectioncommittee.controller.filter.AuthenticationFilter.ROLE_ATTRIBUTE;
import static com.epam.selectioncommittee.controller.util.url.UserUrl.USER;
import static com.epam.selectioncommittee.model.dao.mapper.Columns.USER_ID;


public class GetLogOut implements Command {


    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().setAttribute(USER_ID, null);
        request.getSession().setAttribute(USER, null);
        request.getSession().setAttribute(ROLE_ATTRIBUTE, Role.RoleName.GUEST.name());

        return "redirect:/";

    }
}
