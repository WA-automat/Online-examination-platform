package com.csoep.backend.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * JwtUtil
 * 生成JwtToken和解析Token的工具类
 * @author WA_automat
 * @since 1.0
 */
@Component
public class JwtUtil {
	public static final long JWT_TTL = 60 * 60 * 1000L * 24 * 14;  // 有效期14天
	public static final String JWT_KEY = "CSOEP2003jWT03Online2022Examination2023Platform08Jwt220901LLZJXR20220924CODE";

	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 创建jwt token
	 * @param subject 输入用户id
	 * @return jwtToken
	 */
	public static String createJWT(String subject) {
		JwtBuilder builder = getJwtBuilder(subject, null, getUUID());
		return builder.compact();
	}

	private static JwtBuilder getJwtBuilder(String subject, Long ttlMillis, String uuid) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		SecretKey secretKey = generalKey();
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		if (ttlMillis == null) {
			ttlMillis = JwtUtil.JWT_TTL;
		}

		long expMillis = nowMillis + ttlMillis;
		Date expDate = new Date(expMillis);
		return Jwts.builder()
				.setId(uuid)
				.setSubject(subject)
				.setIssuer("sg")
				.setIssuedAt(now)
				// 由于方法被弃用，在这里修改了参数位置
				.signWith(secretKey, signatureAlgorithm)
				.setExpiration(expDate);
	}

	public static SecretKey generalKey() {
		byte[] encodeKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
		return new SecretKeySpec(encodeKey, 0, encodeKey.length, "HmacSHA256");
	}

	/**
	 * 解析token
	 * @param jwt token
	 * @return 封装了userid的内容
	 * @throws Exception 异常
	 */
	public static Claims parseJWT(String jwt) throws Exception {
		SecretKey secretKey = generalKey();
		return Jwts.parserBuilder()
				.setSigningKey(secretKey)
				.build()
				.parseClaimsJws(jwt)
				.getBody();
	}
}
