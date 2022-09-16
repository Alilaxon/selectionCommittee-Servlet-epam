package com.epam.selectioncommittee.model.dao;

import com.epam.selectioncommittee.model.entity.Faculty;

import java.util.List;

public interface FacultyRepository {

    Faculty save(Faculty faculty);

    Faculty update(Faculty faculty);

    boolean existsByName(String name);

    Faculty findByName(String name);

    Faculty findById(Long id);

    List<Faculty > findAll();


    void deleteById(Long id);


}
