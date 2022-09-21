package com.epam.selectioncommittee.model.builders;

import com.epam.selectioncommittee.model.dto.UserForm;

public class UserFormBuilder {

    private String username;

    private String password;

    private String passwordCopy;

    private String email;

    private String firstname;

    private String surname;

    private String city;

    private String region;

    private String institution;

    public UserFormBuilder() {
    }

    public static UserFormBuilder builder() {

        return new UserFormBuilder();
    }

    public UserFormBuilder username(String username) {
        this.username = username;

        return this;
    }

    public UserFormBuilder password(String password) {
        this.password = password;

        return this;
    }

    public UserFormBuilder passwordCopy(String passwordCopy) {
        this.passwordCopy = passwordCopy;
        return this;
    }

    public UserFormBuilder email(String email) {
        this.email = email;

        return this;

    }

    public UserFormBuilder firstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public UserFormBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public UserFormBuilder city(String city) {
        this.city = city;
        return this;
    }

    public UserFormBuilder region(String region) {
        this.region = region;
        return this;
    }

    public UserFormBuilder institution(String institution) {
        this.institution = institution;
        return this;
    }

    public UserForm build() {
        return new UserForm(username, password,passwordCopy, email
                , firstname, surname, city, region, institution);
    }
}
