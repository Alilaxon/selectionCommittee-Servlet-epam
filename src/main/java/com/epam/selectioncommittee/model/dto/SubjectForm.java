package com.epam.selectioncommittee.model.dto;

public class SubjectForm {

    private String nameEN;

    private String nameRU;

    public SubjectForm() {
    }

    public SubjectForm(String nameEN, String nameRU) {
        this.nameEN = nameEN;
        this.nameRU = nameRU;
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
