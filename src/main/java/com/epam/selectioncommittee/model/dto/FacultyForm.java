package com.epam.selectioncommittee.model.dto;

import com.epam.selectioncommittee.model.entity.Subject;

import java.util.List;

public class FacultyForm {
    private Long id;

    private String facultyName;

    private String facultyNameRU;

    private Integer budgetPlaces;

    private Integer generalPlaces;

    private Boolean recruitment;

    private List<Subject> requiredSubjects;
}
