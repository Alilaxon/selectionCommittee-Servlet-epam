package com.epam.selectioncommittee.model.builders;

import com.epam.selectioncommittee.model.entity.Subject;

public class SubjectBuilder {
    private Long id;

    private String nameEN;

    private String nameRU;

    public static SubjectBuilder builder(){

        return new SubjectBuilder();
    }

    public SubjectBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public SubjectBuilder nameEN(String nameEN) {
        this.nameEN = nameEN;
        return this;
    }

    public SubjectBuilder nameRU(String nameRU) {
        this.nameRU = nameRU;
        return this;
    }

    public Subject build(){

        return new Subject(id,nameEN,nameRU);
    }
}
