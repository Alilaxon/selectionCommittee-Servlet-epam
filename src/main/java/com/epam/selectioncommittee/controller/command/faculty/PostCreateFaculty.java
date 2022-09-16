package com.epam.selectioncommittee.controller.command.faculty;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.controller.mapper.FacultyFormMapper;
import com.epam.selectioncommittee.controller.util.Validator;
import com.epam.selectioncommittee.model.dto.FacultyForm;
import com.epam.selectioncommittee.model.exception.FacultyIsReservedException;
import com.epam.selectioncommittee.model.service.FacultyService;
import com.epam.selectioncommittee.model.service.SubjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class PostCreateFaculty implements Command {

    private static final Logger log = LogManager.getLogger(PostCreateFaculty.class);

    FacultyService facultyService;

    SubjectService subjectService;

    public PostCreateFaculty(FacultyService facultyService,
                             SubjectService subjectService) {
        this.facultyService = facultyService;
        this.subjectService = subjectService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        FacultyForm facultyForm = FacultyFormMapper.mapper(request);

        log.info("new faculty {}",facultyForm.getFacultyName());

        if (Validator.facultyValid(facultyForm)) {

            request.setAttribute("hasErrors", true);
            request.setAttribute("facultyForm", facultyForm);
            request.setAttribute("subjects", subjectService.getAllSubjects());

            return "jsp/admin/createFaculty.jsp";
        }

        try {
            facultyService.addFaculty(facultyForm);

            return "redirect:/faculties";

        } catch (FacultyIsReservedException exception) {

            request.setAttribute("subjects", subjectService.getAllSubjects());


            return "jsp/admin/createFaculty.jsp";
        }


    }
}
