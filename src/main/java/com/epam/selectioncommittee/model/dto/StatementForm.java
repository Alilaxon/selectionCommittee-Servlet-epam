package com.epam.selectioncommittee.model.dto;

import java.util.List;

public class StatementForm {

    String userId;

    String facultyId;

    List<Long> grades;

    public StatementForm() {
    }

    public StatementForm(String userId, String facultyId, List<Long> grades) {
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

    public List<Long> getGrades() {
        return grades;
    }

    public void setGrades(List<Long> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "StatementForm{" +
                "userId='" + userId + '\'' +
                ", facultyId='" + facultyId + '\'' +
                ", grades=" + grades +
                '}';
    }
}
