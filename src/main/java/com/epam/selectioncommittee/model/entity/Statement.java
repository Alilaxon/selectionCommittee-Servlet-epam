package com.epam.selectioncommittee.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class Statement implements Serializable {
    private Long id;

    private Faculty facultyId;

    private User userId;

    private Long gradePointAverage;

    private Position position;


    public Statement() {
    }

    public Statement(Long id, Faculty facultyId, User userId, Long gradePointAverage,Position position) {

        this.id = id;
        this.facultyId = facultyId;
        this.userId = userId;
        this.gradePointAverage = gradePointAverage;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Faculty getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Faculty facultyId) {
        this.facultyId = facultyId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Long getGradePointAverage() {
        return gradePointAverage;
    }

    public void setGradePointAverage(Long gradePointAverage) {
        this.gradePointAverage = gradePointAverage;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Statement)) return false;
        Statement statement = (Statement) o;
        return facultyId.equals(statement.facultyId) && userId.equals(statement.userId) && gradePointAverage.equals(statement.gradePointAverage) && position.equals(statement.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyId, userId, gradePointAverage, position);
    }

    @Override
    public String toString() {
        return "Statement{" +
                "id=" + id +
                ", facultyId=" + facultyId +
                ", userId=" + userId +
                ", gradePointAverage=" + gradePointAverage +
                ", position=" + position +
                '}';
    }
}
