package com.csoep.backend.service.user;

import com.csoep.backend.utils.ResponseResult;

/**
 * 重置密码接口
 */
public interface ResetService {
	ResponseResult resetPassword(String email, String checkCode, String password, String confirmPassword);
}
