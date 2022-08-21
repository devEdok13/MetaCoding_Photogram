package com.cos.photogramstart.web.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CMResponseDto<T> {
  private int code;   // 1: 성공, -1: 실패
  private String message;
  private T data;
}
