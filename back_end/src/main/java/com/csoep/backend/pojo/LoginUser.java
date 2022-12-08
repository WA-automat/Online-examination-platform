package com.csoep.backend.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LoginUser类
 * 实现UserDetails接口
 *
 * @author WA_automat
 * @Since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser implements UserDetails {

	// 私有成员User
	private User user;

	// 封装权限的字符串列表permissions
	private List<String> permissions;

	// 权限信息
	@JSONField(serialize = false)
	private List<SimpleGrantedAuthority> authorities;

	public LoginUser(User user, List<String> permissions) {
		this.user = user;
		this.permissions = permissions;
	}

	/**
	 * 获取权限集合
	 *
	 * @return 权限集合
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (authorities != null) {
			return authorities;
		}

		// 将permissions中的字符串封装成权限信息
		authorities = permissions.stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		return authorities;
	}

	/**
	 * 获取用户密码
	 * 调用User类的获取用户密码函数即可
	 *
	 * @return 用户密码
	 */
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	/**
	 * 获取用户名
	 * 调用User类的获取用户名函数即可
	 *
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
