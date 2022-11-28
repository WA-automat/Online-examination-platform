package com.csoep.backend.service.Impl.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.csoep.backend.mapper.UserMapper;
import com.csoep.backend.pojo.LoginUser;
import com.csoep.backend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 实现UserDetailsService接口
 * 完成过滤器之一
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	/**
	 * 导入UserMapper
	 */
	@Autowired
	private UserMapper userMapper;

	/**
	 * 实现UserDetailsService接口方法loadUserByUsername
	 *
	 * @param username 用户名
	 * @return 封装后的UserDetails
	 * @throws UsernameNotFoundException 异常
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// 使用UserMapper查询用户信息
		LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(User::getUsername, username);
		User user = userMapper.selectOne(queryWrapper);

		// 判断获取的user是否为空
		// 如果为空则抛出异常
		if (Objects.isNull(user)) {
			throw new RuntimeException("用户名或密码错误");
		}

		// TODO 查询用户的权限信息

		// 把数据封装成UserDetails对象返回
		return new LoginUser(user);
	}
}
