package com.api.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class GlobalException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final String code;
  private final String message;
  private final Throwable cause;
  private final HttpStatus status;

  public GlobalException(String code, String message, Throwable cause) {
    this(code, message, cause, null);

  }

  public GlobalException(String code, String message) {
    this(code, message, null, null);
  }

  public GlobalException(String code, String message, HttpStatus status) {
    this(code, message, null, status);
  }


  @Override
  public String toString() {
    return String.format("CpsException[code=%s, message='%s', cause='%s']", code, message, cause);
  }
}
