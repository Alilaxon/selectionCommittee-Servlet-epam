package com.epam.selectioncommittee.controller.util;

import com.epam.selectioncommittee.model.entity.Faculty;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorter {

    private Sorter() {
    }

    public static List<Faculty> facultySorting(List<Faculty> input, String sort, String order) {
        List<Faculty> facultyList;
        if (sort.equals("generalPlaces")) {
            if (order.equals("desc")) {
                facultyList = input.stream()
                        .sorted(Comparator.comparing(Faculty::getGeneralPlaces).reversed())
                        .collect(Collectors.toList());
            } else {
                facultyList = input.stream()
                        .sorted(Comparator.comparing(Faculty::getGeneralPlaces))
                        .collect(Collectors.toList());
            }
        } else if (sort.equals("budgetPlaces")) {
            if (order.equals("desc")) {
                facultyList = input.stream()
                        .sorted(Comparator.comparing(Faculty::getBudgetPlaces).reversed())
                        .collect(Collectors.toList());
            } else {
                facultyList = input.stream()
                        .sorted(Comparator.comparing(Faculty::getBudgetPlaces))
                        .collect(Collectors.toList());
            }
        } else {
            if (order.equals("desc")) {
                facultyList = input.stream()
                        .sorted(Comparator.comparing(Faculty::getFacultyName).reversed())
                        .collect(Collectors.toList());
            } else {

                facultyList = input.stream()
                        .sorted(Comparator.comparing(Faculty::getFacultyName))
                        .collect(Collectors.toList());
            }
        }
        return facultyList;
    }

//    public static Pageable subjectSorting(String page, String size) {
//
//        return PageRequest.of(Integer.parseInt(page) - 1,
//                Integer.parseInt(size), Sort.by("id").ascending());
//
//    }
//
//    public static Pageable userSorting(String order, String sort, String page, String size) {
//
//        if (order.equals("asc")) {
//
//            return PageRequest.of(Integer.parseInt(page) - 1,
//                    Integer.parseInt(size), Sort.by(sort).ascending());
//        }
//
//        return PageRequest.of(Integer.parseInt(page) - 1,
//                Integer.parseInt(size), Sort.by(sort).descending());
//
//
//    }
}
