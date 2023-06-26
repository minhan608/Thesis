package com.api.exception;

import java.time.LocalDateTime;
import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler {
  
  @ExceptionHandler(GlobalException.class)
  public ResponseEntity<ErrorMessage> handleCpsException(final GlobalException ex,
      WebRequest webRequest) {

      HttpStatus status =
        Objects.isNull(ex.getStatus()) ? HttpStatus.INTERNAL_SERVER_ERROR : ex.getStatus();

    final ErrorMessage errorMessage = ErrorMessage.builder()
        .path(((ServletWebRequest) webRequest).getRequest().getRequestURI())
        .timestamp(LocalDateTime.now())
        .status(status)
        .code(ex.getCode())
        .message(ex.getMessage())
        .build();
    errorMessage.setCause(null);
    return ResponseEntity.status(status).body(errorMessage);
  }


}
