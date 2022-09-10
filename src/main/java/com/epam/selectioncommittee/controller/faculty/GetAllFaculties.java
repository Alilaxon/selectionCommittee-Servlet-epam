package com.epam.selectioncommittee.controller.faculty;

import com.epam.selectioncommittee.controller.Command;
import com.epam.selectioncommittee.controller.util.Sorter;
import com.epam.selectioncommittee.model.service.FacultyService;

import javax.servlet.http.HttpServletRequest;

public class GetAllFaculties implements Command {

    FacultyService facultyService;

    public GetAllFaculties(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String sort = request.getParameter("sort");
        String order = request.getParameter("sort");

        request.setAttribute("sort", sort);
        request.setAttribute("order", order);
        request.setAttribute("faculties", Sorter.facultySorting(facultyService.getAllFaculties(), sort, order));

        return "jsp/admin/faculties.jsp";
    }
}
