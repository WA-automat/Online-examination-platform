package com.csoep.backend.handler;

import com.alibaba.fastjson.JSON;
import com.csoep.backend.utils.ResponseResult;
import com.csoep.backend.utils.WebUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl
		implements AuthenticationEntryPoint {
	@Override
	public void commence(
			HttpServletRequest request,
			HttpServletResponse response,
			AuthenticationException authException
	) throws IOException, ServletException {
		// 处理异常
		ResponseResult result = new ResponseResult(HttpStatus.UNAUTHORIZED.value(), "认证失败，请重新登录", null);
		String json = JSON.toJSONString(result);
		WebUtil.renderString(response, json);
	}
}
