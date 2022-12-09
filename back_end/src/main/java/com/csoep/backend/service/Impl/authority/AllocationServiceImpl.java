package com.csoep.backend.service.Impl.authority;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.csoep.backend.mapper.AssociateItemMapper;
import com.csoep.backend.mapper.RoleMapper;
import com.csoep.backend.mapper.UserMapper;
import com.csoep.backend.pojo.Role;
import com.csoep.backend.pojo.User;
import com.csoep.backend.pojo.UserRoleAssociateItem;
import com.csoep.backend.service.authority.AllocationService;
import com.csoep.backend.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class AllocationServiceImpl implements AllocationService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private AssociateItemMapper associateItemMapper;

	@Override
	public ResponseResult addAllocation(String username, String roleKey) {

		// 查询对应的用户与角色
		LambdaQueryWrapper<User> userWrapper = new LambdaQueryWrapper<>();
		LambdaQueryWrapper<Role> roleWrapper = new LambdaQueryWrapper<>();
		userWrapper.eq(User::getUsername, username);
		roleWrapper.eq(Role::getRoleKey, roleKey);
		User user = userMapper.selectOne(userWrapper);
		Role role = roleMapper.selectOne(roleWrapper);

		// 查询失败的结果
		if (Objects.isNull(user)) {
			Map<String, String> map = new HashMap<>();
			map.put("state", "error");
			return new ResponseResult(400, "用户不存在", map);
		}
		if (Objects.isNull(role)) {
			Map<String, String> map = new HashMap<>();
			map.put("state", "error");
			return new ResponseResult(400, "权限不存在", map);
		}

		// 添加到用户角色关联表中
		UserRoleAssociateItem associateItem = new UserRoleAssociateItem(null, user.getId(), role.getId());
		associateItemMapper.insert(associateItem);

		// 生成响应
		Map<String, String> map = new HashMap<>();
		map.put("state", "success");
		map.put("perms", role.getRoleName());
		return new ResponseResult(200, "赋权成功", map);

	}

	@Override
	public ResponseResult deleteAllocation(String username, String roleKey) {

		// 查询对应的用户与角色
		LambdaQueryWrapper<User> userWrapper = new LambdaQueryWrapper<>();
		LambdaQueryWrapper<Role> roleWrapper = new LambdaQueryWrapper<>();
		LambdaQueryWrapper<UserRoleAssociateItem> associateItemWrapper = new LambdaQueryWrapper<>();
		userWrapper.eq(User::getUsername, username);
		roleWrapper.eq(Role::getRoleKey, roleKey);
		User user = userMapper.selectOne(userWrapper);
		Role role = roleMapper.selectOne(roleWrapper);

		// 查询失败的结果
		if (Objects.isNull(user)) {
			Map<String, String> map = new HashMap<>();
			map.put("state", "error");
			return new ResponseResult(400, "用户不存在", map);
		}
		if (Objects.isNull(role)) {
			Map<String, String> map = new HashMap<>();
			map.put("state", "error");
			return new ResponseResult(400, "权限不存在", map);
		}

		// 查询关联表中的元组
		associateItemWrapper
				.eq(UserRoleAssociateItem::getUserId, user.getId())
				.eq(UserRoleAssociateItem::getRoleId, role.getId());
		UserRoleAssociateItem userRoleAssociateItem = associateItemMapper.selectOne(associateItemWrapper);

		// 查询失败
		if (Objects.isNull(userRoleAssociateItem)) {
			Map<String, String> map = new HashMap<>();
			map.put("state", "error");
			return new ResponseResult(400, "该用户不具备这一权限", map);
		}

		// 删除权限
		associateItemMapper.delete(associateItemWrapper);

		// 返回响应
		Map<String, String> map = new HashMap<>();
		map.put("state", "success");
		map.put("perms", role.getRoleName());
		return new ResponseResult(200, "删除权限成功", map);
	}
}
