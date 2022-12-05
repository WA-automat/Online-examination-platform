package com.csoep.backend;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csoep.backend.mapper.UserMapper;
import com.csoep.backend.pojo.User;
import com.csoep.backend.utils.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

/**
 * SpringBoot测试类
 * 在该类中进行API的测试
 */
@SpringBootTest
class BackEndApplicationTests {

	/**
	 * 导入UserMapper
	 */
	@Autowired
	private UserMapper userMapper;

	/**
	 * 导入JwtUtil
	 */
	@Autowired
	private JwtUtil jwtUtil;

	/**
	 * 测试UserMapper类
	 * 获取所有用户信息
	 */
	@Test
	public void testMapper() {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("username", "admin");
		List<User> users = userMapper.selectList(queryWrapper);
		System.out.println(users);
	}

	/**
	 * 测试PasswordEncoder
	 * 即测试加密工具
	 */
	@Test
	public void passwordEncoderTest() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode("Lzx12345");
		System.out.println(password);
		System.out.println(passwordEncoder
				.matches("Lzx12345",
						"$2a$10$lZiOhjcXsQ0qR4yxKHY4uuGKYjlX9uLPkVlp8TqNvL6sizXeO.ME2")
		);
	}

	/**
	 * 测试Jwt工具类
	 * JwtUtil
	 */
	@Test
	public void JwtUtilTest() throws Exception {
		System.out.println(JwtUtil.createJWT("12345"));
		System.out.println(
				JwtUtil.parseJWT(
						"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI0MzQ2OTg5YjY4Mzg0MTU5YjNkOGE1ZjBkNzkwYzAwNCIsInN1YiI6IjEyMzQ1IiwiaXNzIjoic2ciLCJpYXQiOjE2Njk2MTg4MjEsImV4cCI6MTY3MDgyODQyMX0.YJ52KkHgiQXeeTakyHDpsfnt0gdWYSeFMEJtN1bYByY"
				).get("sub"));
	}

	@Test
	public void JavaMailSenderTest() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

	}
}
