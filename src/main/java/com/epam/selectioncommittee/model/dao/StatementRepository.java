package com.epam.selectioncommittee.model.dao;

import com.epam.selectioncommittee.model.entity.Statement;
import com.epam.selectioncommittee.model.entity.User;

import java.util.List;

public interface StatementRepository {

    Statement save(Statement statement);
    Statement update(Statement statement);

    void deleteById(Long id);

    List<Statement> findAllByUserId(User user);

    List<Statement> findAllByFacultyId(Long facultyId);

    List<Statement> findAllByFacultyIdPages(Long facultyId ,Integer limit, Integer offset);

    int getAllStatementsSize(Long id);

    boolean existsByUserIdAndAndFacultyId(Long userId, Long facultyId);

   void deleteAll(List<Statement> statements);

    void updateAll(List<Statement> statements);
}
