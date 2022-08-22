package com.cos.photogramstart.handler;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.util.Script;
import com.cos.photogramstart.web.dto.auth.CMResponseDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

  // Solution1 : DTO 응답
  /*
  @ExceptionHandler(CustomValidationException.class)
  public CMResponseDto<?> validationException(CustomValidationException e) {
    return new CMResponseDto(-1, e.getMessage(), e.getErrorMap());
  }
  */

  // Solution2 : Script
  @ExceptionHandler(CustomValidationException.class)
  public String validationException(CustomValidationException e) {
    return Script.back(e.getErrorMap().toString());
  }
}

/*
CMResponseDto, Script의 비교
1. 클라이언트에게 응답할 때는 Script가 좋음
2. Ajax 통신 - CMRespDto
3. Android 통신 - CMRespDto

*/