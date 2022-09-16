package com.epam.selectioncommittee.controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;

public class LocaleFilter implements Filter {

    private static final String LANG = "lang";

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (request.getParameter(LANG) != null) {
            request.getSession().setAttribute(LANG, request.getParameter(LANG));
        } else if (request.getSession().getAttribute(LANG) == null) {
            request.getSession().setAttribute(LANG, Locale.ENGLISH);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
