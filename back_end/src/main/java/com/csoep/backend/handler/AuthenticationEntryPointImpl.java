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
import java.util.HashMap;
import java.util.Map;

/**
 * 认证异常实现类
 */
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
		Map<String, String> map = new HashMap<>();
		map.put("state", "error");
		ResponseResult result = new ResponseResult(HttpStatus.UNAUTHORIZED.value(), "认证失败，请重新登录", map);
		String json = JSON.toJSONString(result);
		WebUtil.renderString(response, json);
	}
}
