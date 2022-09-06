package com.epam.selectioncommittee.model.dao;

import com.epam.selectioncommittee.model.entity.Faculty;
import com.epam.selectioncommittee.model.entity.Statement;
import com.epam.selectioncommittee.model.entity.User;

import java.util.List;

public interface StatementRepository {

    Statement save(Statement statement);

    void deleteById(Long id);

    List<Statement> findAllByUserId(User user);

    List<Statement> findAllByFacultyId(Faculty faculty);

    boolean existsByUserIdAndAndFacultyId(User user, Faculty faculty);

   void deleteAll(List<Statement> statements);

}
