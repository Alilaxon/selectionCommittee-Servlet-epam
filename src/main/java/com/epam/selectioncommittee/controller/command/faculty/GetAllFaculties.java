package com.epam.selectioncommittee.controller.command.faculty;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.controller.util.Sorter;
import com.epam.selectioncommittee.model.service.FacultyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class GetAllFaculties implements Command {

    private static final Logger log = LogManager.getLogger(GetAllFaculties.class);

    FacultyService facultyService;

    public GetAllFaculties(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        if (sort == null) sort = "name";

        if(order == null) order = "asc";

        request.setAttribute("sort", sort);
        request.setAttribute("order", order);
        request.setAttribute("faculties", Sorter.facultySorting(facultyService.getAllFaculties(), sort, order));

        return "jsp/admin/faculties.jsp";
    }
}
