package com.epam.selectioncommittee.controller.util.url;

public class StatementUrl {

    private StatementUrl() {
    }

    public static final String CREATE_STATEMENT = "/user/statement";

    public static final String STATEMENTS = "/admin/statements";

    public static final String DELETE_STATEMENT = "/statement/{id}";
}
