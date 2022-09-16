package com.epam.selectioncommittee.controller.mapper;
import com.epam.selectioncommittee.model.builders.FacultyFormBuilder;
import com.epam.selectioncommittee.model.dto.FacultyForm;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


public class FacultyFormMapper {

    public static FacultyForm mapper(HttpServletRequest request){

        return FacultyFormBuilder.builder()
                .facultyName(request.getParameter("facultyName"))
                .facultyNameRU(request.getParameter("facultyName"))
                .budgetPlaces(Integer.valueOf(request.getParameter("budgetPlaces")))
                .generalPlaces(Integer.valueOf(request.getParameter("generalPlaces")))
                .requiredSubjects(Arrays.asList(request.getParameterValues("id")))
                .build();
    }
}
