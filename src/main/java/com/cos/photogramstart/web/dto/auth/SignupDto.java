package com.cos.photogramstart.web.dto.auth;

import com.cos.photogramstart.domain.user.User;
import lombok.Data;

@Data   // Getter, Setter가 포함된 어노테이션
public class SignupDto {
  private String username;
  private String password;
  private String email;
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
