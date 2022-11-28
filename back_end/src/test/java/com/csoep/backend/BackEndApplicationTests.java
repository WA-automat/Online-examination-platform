package com.csoep.backend;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csoep.backend.mapper.UserMapper;
import com.csoep.backend.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BackEndApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testMapper() {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("username","admin");
		List<User> users = userMapper.selectList(queryWrapper);
		System.out.println(users);
	}

}
