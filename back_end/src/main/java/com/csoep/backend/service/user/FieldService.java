package com.csoep.backend.service.user;

import com.csoep.backend.pojo.User;

/**
 * 根据字段(用户名、邮箱、手机号码)获取用户信息的接口
 */
public interface FieldService {
	public User userByField(String field);
}
