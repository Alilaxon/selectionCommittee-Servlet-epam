package com.epam.selectioncommittee.model.builders;

import com.epam.selectioncommittee.model.dto.StatementForm;

import java.util.List;

public class StatementFormBuilder {

    String userId;

    String facultyId;

    List<String> grades;

    public StatementFormBuilder() {
    }

    public static StatementFormBuilder builder() {
        return new StatementFormBuilder();
    }

    public StatementFormBuilder user(String user) {
        this.userId = user;
        return this;
    }

    public StatementFormBuilder faculty(String faculty) {
        this.facultyId = faculty;
        return this;
    }

    public StatementFormBuilder grades(List<String> grades) {
        this.grades = grades;
        return this;
    }

    public StatementForm build(){
        return new StatementForm(userId, facultyId,grades);
    }
}
