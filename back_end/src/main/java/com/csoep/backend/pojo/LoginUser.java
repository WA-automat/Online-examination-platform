package com.csoep.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * LoginUser类
 * 实现UserDetails接口
 * @author WA_automat
 * @Since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser implements UserDetails {

	// 私有成员User
	private User user;

	/**
	 * 获取权限集合
	 * @return 权限集合
	 */
	// TODO 权限集合仍未完善
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	/**
	 * 获取用户密码
	 * 调用User类的获取用户密码函数即可
	 * @return 用户密码
	 */
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	/**
	 * 获取用户名
	 * 调用User类的获取用户名函数即可
	 * @return 用户名
	 */
	@Override
	public String getUsername() {
		return user.getUsername();
	}

	// 下面是各种判断，改为返回true即可

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
