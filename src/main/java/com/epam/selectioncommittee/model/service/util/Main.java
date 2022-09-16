package com.epam.selectioncommittee.model.service.util;

public class Main {
    public static void main(String[] args) {
        SHA256PasswordEncoder passwordEncoder = new SHA256PasswordEncoder();
        System.out.println( passwordEncoder.encode("1"));

    }
}
