package com.example.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StudentStatus {

    STUDYING("Studying"),
    RESERVED("Reserved"),
    ABSENT("Quit");
    private String name;
}
