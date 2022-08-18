package com.cos.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity  //  해당 파일로 시큐리티를 활성화
@Configuration  // IOC
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean   // SecurityConfig가 IOC에 등록될때 @Bean 어노테이션을 읽어서 return 되는 객체를 들고있게됨 -> DI 해서 쓰면됨
  public BCryptPasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    //    super.configure(http);    // 해당 줄 비활성화시, 기존 시큐리티가 가지고 있는 기능이 비활성화됨
    http.csrf().disable();  // CSRF 토큰 비활성화
    http.authorizeRequests()
        // .antMatcher(주소패턴) + .authenticated()
          // 해당하는 주소 패턴들은 인증이 되어야 접속이 가능함
        .antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/**").authenticated()
        // .anyRequest + permitAll 다른 요청들은 모두 허용
        .anyRequest().permitAll()
        .and()
        // .formLogin + loginPage(로그인페이지)
          // login시 (로그인페이지)를 사용
        .formLogin()
        .loginPage("/auth/signin")
        // .로그인 성공시 이동할 페이지
        .defaultSuccessUrl("/");
  }
}
