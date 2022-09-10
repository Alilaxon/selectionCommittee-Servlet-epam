package com.epam.selectioncommittee.controller;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute (HttpServletRequest request);
}
