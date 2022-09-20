package com.epam.selectioncommittee.controller.util.url;

import static com.epam.selectioncommittee.controller.util.url.AdminUrl.ADMIN;

public class SubjectUrl {

    private SubjectUrl() {
    }



    public static final String CREATE_SUBJECT = ADMIN + "/addSubject";

    public static final String SUBJECTS = ADMIN + "/subjects";

    public static final String DELETE_SUBJECT = ADMIN + "/deleteSubject";
}
