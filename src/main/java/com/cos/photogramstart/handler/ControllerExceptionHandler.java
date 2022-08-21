package com.cos.photogramstart.handler;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.web.dto.auth.CMResponseDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(CustomValidationException.class)
  public CMResponseDto<?> validationException(CustomValidationException e) {
    return new CMResponseDto(-1, e.getMessage(), e.getErrorMap());
  }
}
