package com.api.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum ExamStatus {
  
  IN_PROGRESS("In progress"),
  TODO("Todo"),
  DONE("Done"),
  PENDING("Pending");
  private String name;
}
