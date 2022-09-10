package com.epam.selectioncommittee.model.dto;

import java.util.List;

public class StatementForm {

    String userId;

    String facultyId;

    List<String> grades;

    public StatementForm() {
    }

    public StatementForm(String userId, String facultyId, List<String> grades) {
        this.userId = userId;
        this.facultyId = facultyId;
        this.grades = grades;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public List<String> getGrades() {
        return grades;
    }

    public void setGrades(List<String> grades) {
        this.grades = grades;
    }
}
