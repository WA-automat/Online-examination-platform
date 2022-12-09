package com.csoep.backend.service.authority;

import com.csoep.backend.utils.ResponseResult;

/**
 * 权限分配服务的接口
 * 作用是为用户分配角色
 * 或为用户删除角色
 */
public interface AllocationService {
	ResponseResult addAllocation(String username, String roleName);

	ResponseResult deleteAllocation(String username, String roleName);
}
