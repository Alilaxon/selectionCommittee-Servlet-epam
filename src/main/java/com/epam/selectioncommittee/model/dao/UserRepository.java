package com.epam.selectioncommittee.model.dao;

import com.epam.selectioncommittee.model.entity.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    boolean existsByUsername(String name);

    boolean existsByEmail (String email);

    User findByUsername(String username);

    User findById (Long id);

    List<User> findAllByRole();
}
