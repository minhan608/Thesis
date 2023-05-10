package com.api.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskType {

    INGOING("In Going"),
    OUTGOING("Out Going");
    private  String name;
}
