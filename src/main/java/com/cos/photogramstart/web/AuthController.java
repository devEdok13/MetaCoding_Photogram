package com.cos.photogramstart.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller // 1. IOC 등록완료 , 2. 파일을 리턴하는 컨트롤러
public class AuthController {

  @GetMapping("/auth/signin")
  public String signInForm() {
    return "auth/signin";
  }

  @GetMapping("/auth/signup")
  public String signUpForm() {
    return "auth/signup";
  }

  // 회원가입 버튼 클릭 -> /auth/signup -> 가입하기 버튼  클릭-> /auth/signin
  @PostMapping("/auth/signup")
  public String signUp() {
    log.info("실행됨?");
    return "auth/signin";
  }
}
