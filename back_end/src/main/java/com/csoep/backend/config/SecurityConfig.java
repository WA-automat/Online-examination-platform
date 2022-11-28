package com.csoep.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SpringSecurity配置类
 *
 * @author WA_automat
 * ( @since 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	/**
	 * 创建密码加密工具
	 *
	 * @return BCryptPasswordEncoder
	 * @author WA_automat
	 * @since 1.0
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * TODO 需要重新构造
	 * 暴露AuthenticationManager
	 *
	 * @author WA_automat
	 * @since 1.0
	 */
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return null;
//	}

	/**
	 * HttpSecurity的配置
	 *
	 * @param httpSecurity 参数
	 * @return SecurityFilterChain 过滤链
	 * @throws Exception 异常
	 */
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

		// httpSecurity配置
		httpSecurity
				.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
				.antMatchers("/user/login").anonymous()
				.anyRequest().authenticated();

		// 返回过滤链
		return httpSecurity.build();
	}

}
