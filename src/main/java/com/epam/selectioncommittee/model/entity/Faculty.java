package com.epam.selectioncommittee.model.entity;

import java.io.Serializable;
import java.util.List;

public class Faculty implements Serializable {
    private Long id;

    private String facultyName;

    private String facultyNameRU;

    private Integer budgetPlaces;

    private Integer generalPlaces;

    private Boolean recruitment;

    private List<Subject> requiredSubjects;

    public Faculty() {
    }

    public Faculty(Long id, String facultyName, String facultyNameRU,
                   Integer budgetPlaces, Integer generalPlaces, Boolean recruitment,
                   List<Subject> requiredSubjects) {
        this.id = id;
        this.facultyName = facultyName;
        this.facultyNameRU = facultyNameRU;
        this.budgetPlaces = budgetPlaces;
        this.generalPlaces = generalPlaces;
        this.recruitment = recruitment;
        this.requiredSubjects = requiredSubjects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyNameRU() {
        return facultyNameRU;
    }

    public void setFacultyNameRU(String facultyNameRU) {
        this.facultyNameRU = facultyNameRU;
    }

    public Integer getBudgetPlaces() {
        return budgetPlaces;
    }

    public void setBudgetPlaces(Integer budgetPlaces) {
        this.budgetPlaces = budgetPlaces;
    }

    public Integer getGeneralPlaces() {
        return generalPlaces;
    }

    public void setGeneralPlaces(Integer generalPlaces) {
        this.generalPlaces = generalPlaces;
    }

    public Boolean getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(Boolean recruitment) {
        this.recruitment = recruitment;
    }

    public List<Subject> getRequiredSubjects() {
        return requiredSubjects;
    }

    public void setRequiredSubjects(List<Subject> requiredSubjects) {
        this.requiredSubjects = requiredSubjects;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", facultyName='" + facultyName + '\'' +
                ", facultyNameRU='" + facultyNameRU + '\'' +
                ", budgetPlaces=" + budgetPlaces +
                ", generalPlaces=" + generalPlaces +
                ", recruitment=" + recruitment +
                ", requiredSubjects=" + requiredSubjects +
                '}';
    }
}
