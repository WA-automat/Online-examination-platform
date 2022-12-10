package com.csoep.backend.service.Impl.user;

import com.csoep.backend.mapper.UserMapper;
import com.csoep.backend.pojo.User;
import com.csoep.backend.service.user.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 根据字段(用户名、邮箱、手机号码)获取用户信息的接口实现类
 */
@Service
public class FieldServiceImpl implements FieldService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User userByField(String field) {
		return userMapper.userByField(field);
	}
}
