package com.epam.selectioncommittee.controller.command.statement;

import com.epam.selectioncommittee.controller.command.Command;
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
