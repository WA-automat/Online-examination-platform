package com.csoep.backend.filter;

import com.csoep.backend.pojo.LoginUser;
import com.csoep.backend.utils.JwtUtil;
import com.csoep.backend.utils.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 一个Jwt认证过滤器
 *
 * @author WA_automat
 * @since 1.0
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	@Autowired
	private RedisCache redisCache;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		// 获取Token
		String token = request.getHeader("token");

		// 获取不到Token时
		if (!StringUtils.hasText(token)) {
			// 放行
			filterChain.doFilter(request, response);
			return;
		}

		// 解析Token
		String userid;
		try {
			Claims claims = JwtUtil.parseJWT(token);
			userid = claims.getSubject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("token 非法");
		}

		// 根据Token获取用户信息
		String redisKey = "login:" + userid;
		LoginUser loginUser = redisCache.getCacheObject(redisKey);
		if (Objects.isNull(loginUser)) {
			throw new RuntimeException("用户未登录");
		}

		// 存入SecurityContextHolder
		// TODO 权限信息需要补充
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(loginUser, null, null);

		SecurityContextHolder.getContext().setAuthentication(authenticationToken);

		// 放行
		filterChain.doFilter(request, response);
	}
}
