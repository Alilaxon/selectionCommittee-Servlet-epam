package com.epam.selectioncommittee.model.entity;

import java.io.Serializable;

public class Position implements Serializable {

    Long id;

    PositionType positionType;

    public enum PositionType{
        REGISTERED,
        CONTRACT,
        BUDGET,
        REJECTED
    }

    public Position() {
    }

    public Position(Long id, PositionType positionType) {
        this.id = id;
        this.positionType = positionType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }
}
