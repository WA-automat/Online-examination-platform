package com.csoep.backend.service.user;

import com.csoep.backend.pojo.User;
import com.csoep.backend.utils.ResponseResult;

public interface LoginService {
	public ResponseResult login(User user);
}
