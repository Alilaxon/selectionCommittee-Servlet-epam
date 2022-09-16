package com.epam.selectioncommittee.controller.command.faculty;
import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.service.FacultyService;
import javax.servlet.http.HttpServletRequest;

public class PostDeleteFaculty implements Command {

    FacultyService facultyService;

    public PostDeleteFaculty(FacultyService facultyService) {

        this.facultyService = facultyService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        facultyService.deleteFaculty(Long.valueOf(request.getParameter("id")));

        return "redirect:/faculties";
    }
}
