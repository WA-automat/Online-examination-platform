package com.csoep.backend.service.Impl.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.csoep.backend.mapper.AssociateItemMapper;
import com.csoep.backend.mapper.RoleMapper;
import com.csoep.backend.mapper.UserMapper;
import com.csoep.backend.pojo.Role;
import com.csoep.backend.pojo.User;
import com.csoep.backend.pojo.UserRoleAssociateItem;
import com.csoep.backend.service.mail.CheckCodeService;
import com.csoep.backend.service.user.FieldService;
import com.csoep.backend.service.user.RegisterService;
import com.csoep.backend.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 注册接口实现类
 */
@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private FieldService fieldService;

	@Autowired
	private CheckCodeService checkCodeService;

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private AssociateItemMapper associateItemMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public ResponseResult register(
			String username,
			String password,
			String confirmPassword,
			String email,
			String phone,
			String checkCode,
			String roleKey
	) {

		// 用于ResponseResult返回的状态
		Map<String, String> map = new HashMap<>();

		// 两次密码是否一致
		if (!Objects.equals(password, confirmPassword)) {
			map.put("state", "error");
			return new ResponseResult(400, "两次密码不一致", map);
		}

		// 用户名长度检查
		if (username.length() > 16) {
			map.put("state", "error");
			return new ResponseResult(400, "用户名过长", map);
		}

		// 密码长度检查
		if (password.length() < 6 || password.length() > 16) {
			map.put("state", "error");
			return new ResponseResult(400, "密码应设置在6-16位之间", map);
		}

		// 手机号码非法
		if (phone.length() != 11) {
			map.put("state", "error");
			return new ResponseResult(400, "手机号码非法", map);
		}

		// 导入匿名MyBatis-Plus查询类
		LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();

		// 用户名是否重复
		User userFromUsername = fieldService.userByField(username);
		if (!Objects.isNull(userFromUsername)) {
			map.put("state", "error");
			return new ResponseResult(400, "该用户名已被使用", map);
		}

		// 邮箱是否重复
		User userFromEmail = fieldService.userByField(email);
		if (!Objects.isNull(userFromEmail)) {
			map.put("state", "error");
			return new ResponseResult(400, "该邮箱已被使用", map);
		}

		// 手机号码是否重复
		User userFromPhone = fieldService.userByField(phone);
		if (!Objects.isNull(userFromPhone)) {
			map.put("state", "error");
			return new ResponseResult(400, "该手机号码已被使用", map);
		}

		boolean checkResult = checkCodeService.check("register", email, checkCode);
		if (!checkResult) {
			map.put("state", "error");
			return new ResponseResult(400, "验证码错误", map);
		}

		// 找不到对应的权限
		LambdaQueryWrapper<Role> queryWrappers = new LambdaQueryWrapper<>();
		queryWrappers.eq(Role::getRoleKey, roleKey);
		Role role = roleMapper.selectOne(queryWrappers);
		if (Objects.isNull(role)) {
			map.put("state", "error");
			return new ResponseResult(400, "赋予权限错误", map);
		}

		// 注册成功后，将user加入数据库
		User user = new User(
				null,
				username,
				passwordEncoder
						.encode(password),
				email,
				phone);
		userMapper.insert(user);

		// 筛选原先的用户
		LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
		lambdaQueryWrapper.eq(User::getUsername, user.getUsername());
		User newUser = userMapper.selectOne(lambdaQueryWrapper);

		// 为新的用户赋予权限
		// 在这里应该先赋予学生权限
		UserRoleAssociateItem userRoleAssociateItem =
				new UserRoleAssociateItem(
						null,
						newUser.getId(),
						role.getId());
		// 添加到用户角色关联表中
		associateItemMapper.insert(userRoleAssociateItem);


		// 返回成功的ResponseResult
		map.put("state", "success");
		return new ResponseResult(200, "注册成功", map);
	}
}
