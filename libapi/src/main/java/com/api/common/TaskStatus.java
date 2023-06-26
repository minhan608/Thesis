package com.api.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskStatus {

    IN_PROGRESS("In progress"),
    TODO("Todo"),
    DONE("Done"),
    PENDING("Pending");
    private String name;
}
