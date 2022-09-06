package com.epam.selectioncommittee.model.dao;

import com.epam.selectioncommittee.model.entity.Position;

public interface PositionRepository {

    Position findByPositionType(Position.PositionType type);
}
