package com.csoep.backend.service.Impl.user;

import com.alibaba.fastjson.JSON;
import com.csoep.backend.pojo.LoginUser;
import com.csoep.backend.service.user.LoginService;
import com.csoep.backend.utils.JwtUtil;
import com.csoep.backend.utils.RedisCache;
import com.csoep.backend.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 登录服务实现类
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private RedisCache redisCache;

	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private Long port;

	@Override
	public ResponseResult login(String username, String password) {

		// AuthenticationManager 进行用户认证
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(username, password);
		Authentication authenticate = authenticationManager.authenticate(authenticationToken);

		// 如果认证没通过，给出对应提示
		if (Objects.isNull(authenticate)) {
			throw new RuntimeException("登录失败");
		}

		// 如果认证通过，使用userid生成有一个jwt，jwt存入ResponseResult返回
		LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
		String userid = loginUser.getUser().getId().toString();
		String jwt = JwtUtil.createJWT(userid);

		// 将token响应给前端
		Map<String, String> map = new HashMap<>();
		map.put("token", jwt);

		// 更换为Jedis
		// 用户信息存入redis
		Jedis jedis = new Jedis(host, Math.toIntExact((port)));
		jedis.connect();
		jedis.set("login:" + userid, JSON.toJSONString(loginUser));
		// 登录有效期最长为7天(即7天后必须重新登录)
		jedis.expire("login:" + userid, 7 * 24 * 60 * 60L);
//		redisCache.setCacheObject("login:" + userid, loginUser);

		return new ResponseResult<>(200, "登录成功", map);
	}
}
