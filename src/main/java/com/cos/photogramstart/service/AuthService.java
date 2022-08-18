package com.cos.photogramstart.service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service  // 1. IoC 2. Transaction 관리
public class AuthService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Transactional  // Insert,Update,Delete 와 관련된 기능에 사용
  public User 회원가입(User user) {
    // 회원가입 진행
    String rawPassword = user.getPassword();
    String encPassword = bCryptPasswordEncoder.encode(rawPassword);
    user.setPassword(encPassword);
    user.setRole("ROLE_USER");  // 관리자 : ROLE_ADMIN
    User userEntity = userRepository.save(user);
    return userEntity;
  }
}
