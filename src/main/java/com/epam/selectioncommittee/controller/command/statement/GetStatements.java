package com.epam.selectioncommittee.controller.command.statement;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.service.FacultyService;
import com.epam.selectioncommittee.model.service.StatementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class GetStatements implements Command {

    private static final Logger log = LogManager.getLogger(GetStatements.class);

    StatementService statementService;

    FacultyService facultyService;

    public GetStatements(StatementService statementService ,FacultyService facultyService) {
        this.facultyService = facultyService;

        this.statementService = statementService;
    }

    @Override
    public String execute(HttpServletRequest request) {


        Long id =  Long.parseLong(request.getParameter("facultyId"));
        String page = (request.getParameter("page"));

//        String sort = request.getParameter("sort");
//        String order = request.getParameter("order");
//
//        if (sort == null) sort = "name";
//
//        if(order == null) order = "asc";

        if(page == null) page = "1";

        int pages = statementService.getPages(id);

        log.info("Find all by faculty id = {}",id);

//        request.setAttribute("sort", sort);
//        request.setAttribute("order", order);
        request.setAttribute("pages",pages);
        request.setAttribute("page",Integer.parseInt(page));
        request.setAttribute("facultyId", id);
        request.setAttribute("faculty",facultyService.getFaculty(id));
        request.setAttribute("statements"
                ,statementService.findAllStatementsByFacultyPages(id,Integer.parseInt(page)));
        return  "/jsp/admin/statements.jsp";
    }
}
