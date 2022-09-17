package com.epam.selectioncommittee.controller.command.faculty;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.model.entity.Faculty;
import com.epam.selectioncommittee.model.service.FacultyService;
import com.epam.selectioncommittee.model.service.SubjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class GetUpdateFaculty implements Command {

    private static final Logger log = LogManager.getLogger(GetAllFaculties.class);

    FacultyService facultyService;

    SubjectService subjectService;

    public GetUpdateFaculty(FacultyService facultyService, SubjectService subjectService) {
        this.facultyService = facultyService;
        this.subjectService = subjectService;
    }

    @Override
    public String execute(HttpServletRequest request) {


        Faculty faculty = facultyService.getFaculty(Long.valueOf(request.getParameter("facultyId")));

        log.info("faculty {} will be update",faculty.getFacultyName());

        request.setAttribute("subjects", subjectService.getAllSubjects());
        request.setAttribute("faculty", faculty);


        return "jsp/admin/updateFaculty.jsp";
    }
}
