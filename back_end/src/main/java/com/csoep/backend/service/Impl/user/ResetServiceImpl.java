package com.csoep.backend.service.Impl.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.csoep.backend.mapper.UserMapper;
import com.csoep.backend.pojo.User;
import com.csoep.backend.service.mail.CheckCodeService;
import com.csoep.backend.service.user.ResetService;
import com.csoep.backend.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 重置密码实现类
 */
@Service
public class ResetServiceImpl implements ResetService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private CheckCodeService checkCodeService;

	@Override
	public ResponseResult resetPassword(
			String email,
			String checkCode,
			String password,
			String confirmPassword
	) {

		// 邮箱所对应的用户不存在
		LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(User::getEmail, email);
		User user = userMapper.selectOne(queryWrapper);
		if (Objects.isNull(user)) {
			Map<String, String> map = new HashMap<>();
			map.put("state", "error");
			return new ResponseResult(400, "邮箱未被注册", map);
		}

		// 验证码不正确
		if (!checkCodeService.check("reset", email, checkCode)) {
			Map<String, String> map = new HashMap<>();
			map.put("state", "error");
			return new ResponseResult(400, "验证码错误", map);
		}

		// 前后两次密码不一致
		if (!Objects.equals(password, confirmPassword)) {
			Map<String, String> map = new HashMap<>();
			map.put("state", "error");
			return new ResponseResult(400, "两次密码不一致", map);
		}

		// 密码长度检查
		if (password.length() < 6 || password.length() > 16) {
			Map<String, String> map = new HashMap<>();
			map.put("state", "error");
			return new ResponseResult(400, "密码应设置在6-16位之间", map);
		}

		// 重置密码
		user.setPassword(password);

		Map<String, String> map = new HashMap<>();
		// 返回成功的ResponseResult
		map.put("state", "success");
		return new ResponseResult(200, "重置密码成功", map);
	}
}
