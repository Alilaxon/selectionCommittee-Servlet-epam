package com.epam.selectioncommittee.controller.command.statement;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.service.StatementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class GetStatements implements Command {

    private static final Logger log = LogManager.getLogger(GetStatements.class);

    StatementService statementService;

    public GetStatements(StatementService statementService) {
        this.statementService = statementService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        Long id =  Long.parseLong(request.getParameter("facultyId"));
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");

        if (sort == null) sort = "name";

        if(order == null) order = "asc";

        log.info("Find all by faculty id = {}",id);

        request.setAttribute("sort", sort);
        request.setAttribute("order", order);
        request.setAttribute("statements",statementService.findAllStatementsByFaculty(id));
        return  "jsp/admin/statements.jsp";
    }
}
