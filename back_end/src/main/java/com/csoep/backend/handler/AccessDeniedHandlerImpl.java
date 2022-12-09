package com.csoep.backend.handler;

import com.alibaba.fastjson.JSON;
import com.csoep.backend.utils.ResponseResult;
import com.csoep.backend.utils.WebUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
	@Override
	public void handle(
			HttpServletRequest request,
			HttpServletResponse response,
			AccessDeniedException accessDeniedException
	) throws IOException, ServletException {
		// 处理异常
		Map<String, String> map = new HashMap<>();
		map.put("state", "error");
		ResponseResult result = new ResponseResult(HttpStatus.FORBIDDEN.value(), "您的权限不足", map);
		String json = JSON.toJSONString(result);
		WebUtil.renderString(response, json);
	}
}
