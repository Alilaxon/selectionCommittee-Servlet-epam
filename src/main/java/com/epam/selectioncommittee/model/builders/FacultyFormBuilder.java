package com.epam.selectioncommittee.model.builders;

import com.epam.selectioncommittee.model.dto.FacultyForm;

import java.util.List;

public class FacultyFormBuilder {
    private Long id;

    private String facultyName;

    private String facultyNameRU;

    private Integer budgetPlaces;

    private Integer generalPlaces;

    private Boolean recruitment;

    private List<String> requiredSubjects;

    public static FacultyFormBuilder builder() {

        return new FacultyFormBuilder();
    }

    public FacultyFormBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public FacultyFormBuilder facultyName(String facultyName) {
        this.facultyName = facultyName;
        return this;
    }

    public FacultyFormBuilder facultyNameRU(String facultyNameRU) {
        this.facultyNameRU = facultyNameRU;
        return this;
    }

    public FacultyFormBuilder budgetPlaces(Integer budgetPlaces) {
        this.budgetPlaces = budgetPlaces;
        return this;
    }

    public FacultyFormBuilder generalPlaces(Integer generalPlaces) {
        this.generalPlaces = generalPlaces;
        return this;
    }

    public FacultyFormBuilder recruitment(Boolean recruitment) {
        this.recruitment = recruitment;
        return this;
    }

    public FacultyFormBuilder requiredSubjects(List<String> requiredSubjects) {
        this.requiredSubjects = requiredSubjects;
        return this;
    }


    public FacultyForm build() {
        return new FacultyForm(id, facultyName, facultyNameRU, budgetPlaces,
                generalPlaces, recruitment, requiredSubjects);
    }
}
