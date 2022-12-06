package com.csoep.backend.service.Impl.mail;

import com.csoep.backend.service.mail.CheckCodeService;
import com.csoep.backend.utils.MailUtil;
import com.csoep.backend.utils.RedisCache;
import com.csoep.backend.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 验证码实现类
 */
@Service
public class CheckCodeServiceImpl implements CheckCodeService {

	@Autowired
	private RedisCache redisCache;

	@Autowired
	private MailUtil mailSender;

	@Override
	public ResponseResult sendCheckCode(String ops, String to) {

		// 用于返回信息
		Map<String, String> map = new HashMap<>();

		try {
			// 生成验证码
			Random helper = new Random();
			String yzm = "1234567890abcdefghijklmnopqrstuvwxwz";
			StringBuilder code = new StringBuilder();
			for (int i = 0; i < 6; i++) {
				int j = helper.nextInt(yzm.length());
				code.append(yzm.charAt(j));
			}

			// 发送验证码
			String subject = "【oep在线考试平台】验证信息";
			String text = "你正在进行" + ops + "验证操作，验证码：" + code + "\n" + "请勿将验证码泄漏给他人，本条验证码有效期2分钟 ";

			String flag = mailSender.send(to, subject, text);

			if (!Objects.equals(flag, "success")) {
				throw new RuntimeException("error");
			}

			// 将验证码存入redis，并设置过期时间为两分钟
			redisCache.setCacheObject(ops + ":" + to, code.toString());
			redisCache.expire(ops + ":", 2, TimeUnit.MINUTES);

			// 返回ResponseResult
			map.put("state", "success");
			map.put("email", to);
			return new ResponseResult(200, "验证码发送成功", map);

		} catch (Exception e) {

			// 返回ResponseResult
			map.put("state", "error");
			return new ResponseResult(400, "验证码发送失败", map);

		}

	}

	@Override
	public boolean check(String ops, String email, String code) {

		// 从redis中取出验证码
		String checkCode = redisCache.getCacheObject(ops + ":" + email);
		if (Objects.isNull(checkCode)) {
			return false;
		}

		// 检查验证码是否正确
		if (!checkCode.equals(code)) {
			return false;
		}

		// 若正确，需要从redis中删除验证码
		// 没删掉也没关系，我们已经设置验证码时间为2分钟
		redisCache.deleteObject(ops + ":" + email);

		return true;
	}
}
