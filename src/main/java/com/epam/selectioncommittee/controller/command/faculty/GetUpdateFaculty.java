package com.epam.selectioncommittee.controller.command.faculty;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.controller.util.SubjectAdapter;
import com.epam.selectioncommittee.model.builders.FacultyFormBuilder;
import com.epam.selectioncommittee.model.entity.Faculty;
import com.epam.selectioncommittee.model.service.FacultyService;
import com.epam.selectioncommittee.model.service.SubjectService;

import javax.servlet.http.HttpServletRequest;

public class GetUpdateFaculty implements Command {

    FacultyService facultyService;

    SubjectService subjectService;

    public GetUpdateFaculty(FacultyService facultyService, SubjectService subjectService) {
        this.facultyService = facultyService;
        this.subjectService = subjectService;
    }

    @Override
    public String execute(HttpServletRequest request) {


        Faculty faculty = facultyService.getFaculty(Long.valueOf(request.getParameter("facultyId")));

        request.setAttribute("subjects", subjectService.getAllSubjects());
        request.setAttribute("facultyForm", FacultyFormBuilder.builder()
                .id(faculty.getId())
                .facultyName(faculty.getFacultyName())
                .facultyNameRU(faculty.getFacultyNameRU())
                .budgetPlaces(faculty.getBudgetPlaces())
                .generalPlaces(faculty.getGeneralPlaces())
                .requiredSubjects(SubjectAdapter.adapter(faculty.getRequiredSubjects()))
                .recruitment(faculty.getRecruitment())
                .build());

        return "jsp/admin/updateFaculty.jsp";
    }
}
