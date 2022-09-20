package com.epam.selectioncommittee.controller.util.url;

import static com.epam.selectioncommittee.controller.util.url.AdminUrl.ADMIN;
import static com.epam.selectioncommittee.controller.util.url.UserUrl.USER;

public class StatementUrl {

    private StatementUrl() {
    }



    public static final String CREATE_STATEMENT =USER + "/createStatement";

    public static final String STATEMENTS = ADMIN + "/statements";

    public static final String DELETE_STATEMENT = USER + "/deleteStatement";
}
