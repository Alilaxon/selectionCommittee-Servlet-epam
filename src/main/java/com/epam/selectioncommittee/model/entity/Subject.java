package com.epam.selectioncommittee.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class Subject implements Serializable {

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

    @Override
    public String toString() {
        return "Subject{" +
                "nameEN='" + nameEN + '\'' +
                ", nameRU='" + nameRU + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;
        Subject subject = (Subject) o;
        return nameEN.equals(subject.nameEN) &&
                nameRU.equals(subject.nameRU);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameEN, nameRU);
    }
}
