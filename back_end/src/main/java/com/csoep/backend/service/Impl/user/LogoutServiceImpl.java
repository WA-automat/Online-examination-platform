package com.csoep.backend.service.Impl.user;

import com.csoep.backend.pojo.LoginUser;
import com.csoep.backend.service.user.LogoutService;
import com.csoep.backend.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class LogoutServiceImpl implements LogoutService {

	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private Long port;

	@Override
	public ResponseResult logout() {

		// 获取SecurityContextHolder中的用户id
		UsernamePasswordAuthenticationToken authentication =
				(UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		LoginUser loginUser = (LoginUser) authentication.getPrincipal();
		Integer userid = loginUser.getUser().getId();

		// 删除redis中的值
		Jedis jedis = new Jedis(host, Math.toIntExact((port)));
		jedis.connect();
		jedis.del("login:" + userid);

		return new ResponseResult(200, "注销成功", null);
	}
}
