package com.epam.selectioncommittee.model.dao;

import com.epam.selectioncommittee.model.entity.Subject;

import java.util.List;

public interface SubjectRepository {

    Subject save(Subject subject);


    List<Subject> findAll();

    List<Subject> findAllOnPage(Integer limit, Integer offset);


     int getAllSubjectsSize();


    boolean existsByNameEN(String name);

    Subject findById(Long id);

    boolean deleteById(Long id);
}
