package com.epam.selectioncommittee.model.entity;

public class Subject {

    private Long id;

    private String nameEN;

    private String nameRU;

    public Subject() {
    }

    public Subject(Long id, String nameEN, String nameRU) {
        this.id = id;
        this.nameEN = nameEN;
        this.nameRU = nameRU;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public String getNameRU() {
        return nameRU;
    }

    public void setNameRU(String nameRU) {
        this.nameRU = nameRU;
    }
}
