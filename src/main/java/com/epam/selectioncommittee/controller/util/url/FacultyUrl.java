package com.epam.selectioncommittee.controller.util.url;

import static com.epam.selectioncommittee.controller.util.url.AdminUrl.ADMIN;

public class FacultyUrl {

    private FacultyUrl() {
    }


    public static final String CREATE_FACULTY = ADMIN + "/addFaculty";

    public static final String FACULTIES = "/faculties";

    public static final String UPDATE_FACULTY = ADMIN + "/updateFaculty";

    public static final String DELETE_FACULTY = ADMIN + "/deleteFaculty";
}
