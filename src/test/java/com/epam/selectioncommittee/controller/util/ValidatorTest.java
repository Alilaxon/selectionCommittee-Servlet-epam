package com.epam.selectioncommittee.controller.util;

import com.epam.selectioncommittee.model.builders.UserFormBuilder;
import com.epam.selectioncommittee.model.dto.UserForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
class ValidatorTest {

    private UserForm USER_FORM;

    private HttpServletRequest request = mock(HttpServletRequest.class);
    private final static String USERNAME = "TestUser";

    private final static String PASSWORD = "Qwerty12";

    private final static String PASSWORD_COPY = "Qwerty12";

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
        assertTrue(Validator.validate(USER_FORM, request));
    }

    @Test
    void validateUsername() {
        String INCORRECT_FEILD = "qq";
        USER_FORM.setUsername(INCORRECT_FEILD);
        assertFalse(Validator.validate(USER_FORM, request));
    }

    @Test
    void validatePasswordSize() {
        String INCORRECT_FEILD = "qq";
        USER_FORM.setPassword(INCORRECT_FEILD);
        assertFalse(Validator.validate(USER_FORM, request));
    }

    @Test
    void validatePasswordPattern() {
        String INCORRECT_FEILD = "qqqqqqqqqq";
        USER_FORM.setPassword(INCORRECT_FEILD);
        assertFalse(Validator.validate(USER_FORM, request));
    }

    @Test
    void validatePasswordCopy() {
        String INCORRECT_FEILD = "qq";
        USER_FORM.setPasswordCopy(INCORRECT_FEILD);
        assertFalse(Validator.validate(USER_FORM, request));
    }

    @Test
    void validateEmailSize() {
        String INCORRECT_FEILD = "qqqqqqq";
        USER_FORM.setEmail(INCORRECT_FEILD);
        assertFalse(Validator.validate(USER_FORM, request));
    }

    @Test
    void validateEmailPattern() {
        String INCORRECT_FEILD = "qqqqqqqqqq";
        USER_FORM.setEmail(INCORRECT_FEILD);
        assertFalse(Validator.validate(USER_FORM, request));
    }

    @Test
    void validateFirstname() {
        String INCORRECT_FEILD = "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq";
        USER_FORM.setFirstname(INCORRECT_FEILD);
        assertFalse(Validator.validate(USER_FORM, request));
    }

    @Test
    void validateSurname() {
        String INCORRECT_FEILD = "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq";
        USER_FORM.setSurname(INCORRECT_FEILD);
        assertFalse(Validator.validate(USER_FORM, request));
    }

    @Test
    void validateCity() {
        String INCORRECT_FEILD = "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq";
        USER_FORM.setCity(INCORRECT_FEILD);
        assertFalse(Validator.validate(USER_FORM, request));
    }

    @Test
    void validateRegion() {
        String INCORRECT_FEILD = "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq";
        USER_FORM.setRegion(INCORRECT_FEILD);
        assertFalse(Validator.validate(USER_FORM, request));
    }
    @Test
    void validateInstitution() {
        String INCORRECT_FEILD = "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq";
        USER_FORM.setInstitution(INCORRECT_FEILD);
        assertFalse(Validator.validate(USER_FORM ,request));
    }
}