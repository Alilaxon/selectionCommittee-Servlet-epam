package com.epam.selectioncommittee.controller.util;

public class Pages {
    String sort;
    String order;
    Long limit;
    Long offset;

    public Pages() {
        this.sort = "asc";
        this.order = "name";
        this.limit = 999L;
        this.offset = 0L;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }
}
