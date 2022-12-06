package com.csoep.backend.service.mail;

import com.csoep.backend.utils.ResponseResult;

/**
 * 验证码接口
 */
public interface CheckCodeService {
	public ResponseResult sendCheckCode(String ops, String to);
	public boolean check(String ops, String email, String code);
}
