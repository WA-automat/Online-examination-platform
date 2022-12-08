package com.csoep.backend.config;

import com.csoep.backend.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * SpringSecurity配置类
 *
 * @author WA_automat
 * ( @since 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

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
	 * 暴露AuthenticationManager
	 *
	 * @author WA_automat
	 * @since 1.0
	 */
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

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
				//放行swagger
				.antMatchers("/swagger-ui.html","/swagger-resources/**","/webjars/**","/v2/**","/api/**").permitAll()
				// 放行注册和登录接口
				.antMatchers("/user/register", "/user/login").anonymous()
				.anyRequest().authenticated();

		// 配置认证过滤器
		httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

		// 返回过滤链
		return httpSecurity.build();
	}

	/**
	 * 配置全局的某些通用事物，例如静态资源等
	 *
	 * @return WebSecurityCustomizer
	 */
	@Bean
	public WebSecurityCustomizer securityCustomizer() {
		return (web) -> web.ignoring().antMatchers(
				"/swagger-ui.html",
				"/v2/api-docs", // swagger api json
				"/swagger-resources/configuration/ui", // 用来获取支持的动作
				"/swagger-resources", // 用来获取api-docs的URI
				"/swagger-resources/configuration/security", // 安全选项
				"/swagger-resources/**",
				//补充路径，近期在搭建swagger接口文档时，通过浏览器控制台发现该/webjars路径下的文件被拦截，故加上此过滤条件即可。(2020-10-23)
				"/webjars/**"
		);
	}

}
