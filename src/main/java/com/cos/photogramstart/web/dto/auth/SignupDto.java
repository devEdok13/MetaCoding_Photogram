package com.cos.photogramstart.web.dto.auth;

import com.cos.photogramstart.domain.user.User;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data   // Getter, Setter가 포함된 어노테이션
public class SignupDto {
//  L23 : 프론트 단에서 입력값 제한("required"사용)이 있어도 postman 등의 api로 들어오는 요청에 대해서 백엔드 단에서도 Validation을 이용하여 제한해야함
  @Size(min = 2, max = 20)
  @NotBlank
  private String username;
  @NotBlank
  private String password;
  @NotBlank
  private String email;
  @NotBlank
  private String name;

  public User toEntity() {
    return User.builder()
               .username(username)
               .password(password)
               .email(email)
               .name(name)
               .build();
  }
}
