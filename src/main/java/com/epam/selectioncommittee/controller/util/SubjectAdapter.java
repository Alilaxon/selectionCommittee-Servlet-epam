package com.epam.selectioncommittee.controller.util;

import com.epam.selectioncommittee.model.entity.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectAdapter {

    private SubjectAdapter() {
    }

    public static List<String> adapter (List<Subject> list){
        List<String> strings = new ArrayList<>();

        for (Subject subject: list) {
            strings.add(subject.getNameEN());

        }
        return strings;
    }
}
