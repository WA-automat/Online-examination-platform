package com.csoep.backend.service.Impl.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.csoep.backend.mapper.UserMapper;
import com.csoep.backend.pojo.User;
import com.csoep.backend.service.user.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldServiceImpl implements FieldService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User userByField(String field) {

		// 匿名查询类
		LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();

		// 根据用户名查找
		queryWrapper
				.eq(User::getUsername, field)
				.or()
				.eq(User::getEmail, field)
				.or()
				.eq(User::getPhone, field);

		// 获取用户
		return userMapper.selectOne(queryWrapper);
	}
}
