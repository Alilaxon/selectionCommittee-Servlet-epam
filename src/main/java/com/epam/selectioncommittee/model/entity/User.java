package com.epam.selectioncommittee.model.entity;

import java.io.Serializable;

public class User implements Serializable {

    private Long id;

    private String username;

    private String password;

    private String email;

    private String firstname;

    private String surname;

    private String city;

    private String region;

    private String  institution;

    private Role role;

    private Boolean blocked;

    public User() {
    }

    public User(Long id, String username, String password, String email,
                String firstname, String surname, String city, String region,
                String institution, Role role, Boolean blocked) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.surname = surname;
        this.city = city;
        this.region = region;
        this.institution = institution;
        this.role = role;
        this.blocked = blocked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", institution='" + institution + '\'' +
                ", role=" + role +
                ", blocked=" + blocked +
                '}';
    }
}
