package com.epam.selectioncommittee.controller.util;

import com.epam.selectioncommittee.model.dto.FacultyForm;

public class Validator {

    private Validator() {
    }

    public static boolean facultyValid(FacultyForm facultyForm){
        return facultyForm.getBudgetPlaces() > facultyForm.getGeneralPlaces()
                || facultyForm.getRequiredSubjects().size() < 2;
    }
}
