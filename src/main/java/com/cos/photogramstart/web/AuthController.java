package com.cos.photogramstart.web;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor  //  final필드를 DI할 때 사용
@Slf4j
@Controller // 1. IOC 등록완료 , 2. 파일을 리턴하는 컨트롤러
public class AuthController {

  private final AuthService authService;

// @RequiredArgsConstructor + final 필드로 생성자로 DI주입 생략
/*
    public AuthController(AuthService authService) {
    this.authService = authService;
  }
 */

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
  public String signUp(SignupDto signupDto) { //  key=value (x-www-form-urlencoded)
    log.info(signupDto.toString());
    // User <- SignupDto
    User user = signupDto.toEntity();
    log.info(user.toString());
    User userEntity = authService.회원가입(user);
    log.info(userEntity.toString());
    return "auth/signin";
  }
}

/*
L19 DI 주입관련
1. @Autowired
2. 생성자를 이용한 DI 주입
3. @RequiredArgsConstructor을 이용한 DI 주입
    - final 필드에 대해서 생성자를 만들어줌
*/