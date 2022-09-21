package com.epam.selectioncommittee.controller.filter;

import com.epam.selectioncommittee.model.entity.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.epam.selectioncommittee.controller.util.url.AdminUrl.ADMIN;
import static com.epam.selectioncommittee.controller.util.url.FacultyUrl.FACULTIES;
import static com.epam.selectioncommittee.controller.util.url.UserUrl.*;

public class AuthenticationFilter implements Filter {

    private static final Logger log = LogManager.getLogger(AuthenticationFilter.class);

    public static final String ROLE_ATTRIBUTE = "role";


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

            log.info("get role = GUEST");
        }

        Role.RoleName role = Role.RoleName.valueOf(session.getAttribute(ROLE_ATTRIBUTE).toString());

        if (!checkAccess(URI, role)) {
            if (role.equals(Role.RoleName.GUEST)) {
                response.sendRedirect(request.getContextPath() + LOGIN);
            }


            log.info("something wrong");
            return;
        }
        log.info("everything good");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean checkAccess(String uri, Role.RoleName roleName) {
        switch (roleName) {
            case USER:
                return checkUserAccess(uri);
            case ADMIN:
                return checkAdminAccess(uri);
            default:
                return checkGuestAccess(uri);
        }
    }

    private boolean checkAdminAccess(String uri) {

        return checkCommonAccess(uri) || uri.startsWith(ADMIN) || uri.equals(LOGOUT);
    }

    private boolean checkUserAccess(String uri) {
        return checkCommonAccess(uri) || uri.startsWith(USER) || uri.equals(LOGOUT);
    }

    private boolean checkGuestAccess(String uri) {

        return checkCommonAccess(uri) || uri.equals(LOGIN) || uri.equals(REGISTRATION) || uri.equals(REGISTERED);
    }

    private boolean checkCommonAccess(String uri) {

        return uri.equals(FACULTIES) || uri.equals("/");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
