package com.epam.selectioncommittee.controller.filter;

import com.epam.selectioncommittee.model.entity.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter {

    String ROLE_ATTRIBUTE = "role";

    private static final String USER_ID_ATTRIBUTE = "userId";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        final String URI = request.getRequestURI();

        if (session.getAttribute(ROLE_ATTRIBUTE) == null) {
            session.setAttribute(ROLE_ATTRIBUTE, Role.RoleName.GUEST.toString());
        }

        Role.RoleName role = Role.RoleName.valueOf(session.getAttribute(ROLE_ATTRIBUTE).toString());

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
