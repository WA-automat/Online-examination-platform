package com.csoep.backend.controller;

import com.csoep.backend.mapper.UserMapper;
import com.csoep.backend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/hello")
	public String hello() {
		List<User> users = userMapper.selectList(null);
		return users.toString();
	}

}
