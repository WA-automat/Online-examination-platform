package com.csoep.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
	public List<User> hello() {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("email", "1577696824@qq.com");
		return userMapper.selectList(queryWrapper);
	}

}
