package com.xiaomy.book_city.common.security.config;

import com.xiaomy.book_city.common.security.errror.CustomAccessDeniedHandler;
import com.xiaomy.book_city.common.security.errror.EntryPointUnauthorizedHandler;
import com.xiaomy.book_city.common.security.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // - 开启SpringSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // - 启用SpringSecurity注解的方式
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsService userDetailsService; // - springSecurity封装的 操作user的service

  @Autowired
  private CustomAccessDeniedHandler accessDeniedHandler;// 无权访问返回的JSON 格式数据给前端（否则为 403 html 页面）

  @Autowired
  private EntryPointUnauthorizedHandler entryPointUnauthorizedHandler; // token无效或者未携带token时候的异常


  @Autowired
  public void configAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder)
      throws Exception {
    authenticationManagerBuilder
        .userDetailsService(this.userDetailsService)
        .passwordEncoder(new BCryptPasswordEncoder());
  }

  /**
   *  - 配置要拦截Http要拦截的请求
   * @param http
   * @throws Exception
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeRequests()
        .antMatchers(
            "/",
            "/*.html",
            "/swagger-resources/**",
            "/v2/api-docs/**",
            "/favicon.ico",
            "/**/*.html",
            "/**/*.css",
            "/**/*.js"
        ).permitAll()
        .antMatchers("/Auth/**").permitAll()
        .anyRequest().authenticated();
    http.headers().cacheControl();

    http.exceptionHandling().accessDeniedHandler(accessDeniedHandler) // - 没有权限情况下使用自定义的报错机制给请求者
        .authenticationEntryPoint(entryPointUnauthorizedHandler);   // - token无效

    http.addFilterBefore(authenticationTokenFilterBean(),
        UsernamePasswordAuthenticationFilter.class);
  }

  @Bean
  public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
    return new JwtAuthenticationTokenFilter();
  }

  /**
   * 解决authenticationManager无法注入问题
   * @return
   * @throws Exception
   */
  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
}
