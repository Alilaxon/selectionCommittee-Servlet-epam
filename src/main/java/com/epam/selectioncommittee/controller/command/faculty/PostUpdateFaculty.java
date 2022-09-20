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

public class PostUpdateFaculty implements Command {

    private static final Logger log = LogManager.getLogger(PostUpdateFaculty.class);

    SubjectService subjectService;

    FacultyService facultyService;

    public PostUpdateFaculty(SubjectService subjectService, FacultyService facultyService) {
        this.subjectService = subjectService;
        this.facultyService = facultyService;
    }

    @Override
    public String execute(HttpServletRequest request) {


        //TODO
        Long facultyId = Long.parseLong(request.getParameter("facultyId"));
        FacultyForm facultyForm = FacultyFormMapper.mapper(request,facultyId);

        if (Validator.facultyValid(facultyForm)) {

            request.setAttribute("hasErrors", true);
            request.setAttribute("subjects", subjectService.getAllSubjects());

            return "/jsp/admin/updateFaculty.jsp";
        }

        try {

          log.info("Temp ms {}",facultyForm.toString());

            facultyService.updateFaculty(facultyForm);

            return "redirect:/faculties";

        } catch (FacultyIsReservedException exception) {
            request.setAttribute("FacultyIsReserved", true);
            request.setAttribute("subjects", subjectService.getAllSubjects());


            return "/jsp/admin/updateFaculty.jsp";
        }

    }
}
