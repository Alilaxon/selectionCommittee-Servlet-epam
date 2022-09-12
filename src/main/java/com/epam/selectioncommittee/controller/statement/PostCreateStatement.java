package com.epam.selectioncommittee.controller.statement;

import com.epam.selectioncommittee.controller.Command;
import com.epam.selectioncommittee.model.service.StatementService;

import javax.servlet.http.HttpServletRequest;

public class PostCreateStatement implements Command {

    StatementService statementService;

    public PostCreateStatement(StatementService statementService) {
        this.statementService = statementService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        //TODO

        return null;
    }
}
