package com.csoep.backend;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csoep.backend.mapper.MenuMapper;
import com.csoep.backend.mapper.UserMapper;
import com.csoep.backend.pojo.User;
import com.csoep.backend.service.mail.CheckCodeService;
import com.csoep.backend.utils.JwtUtil;
import com.csoep.backend.utils.ResponseResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Scanner;

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
	 * 导入JwtUtil
	 */
	@Autowired
	private JwtUtil jwtUtil;

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

	@Autowired(required = false)
	private JavaMailSender sender; // 引入Spring Mail依赖后，会自动装配到IOC容器。用来发送邮件

	/**
	 * 测试JavaMailSender
	 */
	@Test
	public void JavaMailSenderTest() {
		String code = "xxx"; // 验证码
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("【xxx】验证消息"); // 发送邮件的标题
		message.setText("你正在进行登录操作，验证码：" + code + "，切勿将验证码泄露给他人，本条验证码有效期2分钟。"); // 发送邮件的内容
		message.setTo("1577696824@qq.com"); // 登录用户的邮箱账号
		message.setFrom("csoep_scnu@163.com"); // 发送邮件的邮箱账号，注意一定要和配置文件中的一致！
		sender.send(message);
	}

	@Autowired
	private CheckCodeService checkCodeService;

	/**
	 * 测试CheckCodeService
	 */
	@Test
	public void CheckCodeServiceTest() {
		ResponseResult responce = checkCodeService.sendCheckCode("test", "1577696824@qq.com");
		System.out.println(responce);
	}

	@Test
	public void checkCodeTest() {
		System.out.println(checkCodeService.check("test", "1577696824@qq.com", "hx4o97"));
	}

	@Autowired
	private MenuMapper menuMapper;

	@Test
	public void testMenuMapper() {
		List<String> perms = menuMapper.selectPermsByUserId(1);
		System.out.println(perms);
	}
}
