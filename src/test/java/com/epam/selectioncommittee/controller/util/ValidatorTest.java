package com.epam.selectioncommittee.controller.util;

import com.epam.selectioncommittee.model.builders.UserFormBuilder;
import com.epam.selectioncommittee.model.dto.UserForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    private UserForm USER_FORM;

    private final static String USERNAME = "TestUser";

    private final static String PASSWORD = "qwerty12";

    private final static String PASSWORD_COPY = "qwerty12";

    private final static String EMAIL = "HarryPotter@gmail.com";

    private final static String FIRSTNAME = "Harry";

    private final static String SURNAME = "Potter";

    private final static String CITY = "London";

    private final static String REGION = "England";

    private final static String INSTITUTION = "Hogwarts";

    @BeforeEach
    void setUp() {
        USER_FORM = UserFormBuilder.builder()
                .username(USERNAME)
                .password(PASSWORD)
                .passwordCopy(PASSWORD_COPY)
                .email(EMAIL)
                .firstname(FIRSTNAME)
                .surname(SURNAME)
                .city(CITY)
                .region(REGION)
                .institution(INSTITUTION)
                .build();
    }

    @Test
    void validate() {
    }
}