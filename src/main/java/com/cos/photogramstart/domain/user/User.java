package com.cos.photogramstart.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

//  JPA - Java Persistence Api (자바로 데이터를 영구적으로 저장(DB에 저장)할 수 있는 API를 제공)

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // DB에 Table을 생성
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략이 DB를 따라간다 (mysql : auto-increment 전략, oracle : sequence 전략)
  private Long id;

  @Column(unique = true, length = 20)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String email;

  private String website;

  private String bio; // 자기소개

  private String phone;

  private String gender;

  private String profileImageUrl;

  private String role;

  private LocalDateTime createdDate;

  @PrePersist // DB에 INSERT 되기 직전에 실행
  public void createDate(){
    this.createdDate = LocalDateTime.now();
  }
}
