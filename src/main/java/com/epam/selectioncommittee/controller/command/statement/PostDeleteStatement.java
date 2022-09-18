package com.epam.selectioncommittee.controller.command.statement;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.service.StatementService;

import javax.servlet.http.HttpServletRequest;

public class PostDeleteStatement implements Command {

    StatementService statementService;

    public PostDeleteStatement(StatementService statementService) {
        this.statementService = statementService;
    }

    @Override
    public String execute(HttpServletRequest request) {
       Long id =Long.parseLong(request.getParameter("statementId"));
       statementService.deleteStatement(id);
        //TODO
        return "redirect:/";
    }
}
