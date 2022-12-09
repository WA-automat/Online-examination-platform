package com.csoep.backend.controller;

import com.csoep.backend.service.authority.AllocationService;
import com.csoep.backend.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分配与删除用户角色权限的API
 */
@Api(value = "角色权限API")
@RestController
public class AllocationController {

	@Autowired
	private AllocationService allocationService;

	@ApiOperation(value = "分配超级管理员权限")
	@PostMapping("/alloc/add/admin")
	@PreAuthorize("hasAuthority('system:alloc:add:admin:list')")
	@ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名")})
	public ResponseResult addAdminAllocation(@RequestParam String username) {
		return allocationService.addAllocation(username, "admin");
	}

	@ApiOperation(value = "分配管理员权限")
	@PostMapping("/alloc/add/manager")
	@PreAuthorize("hasAuthority('system:alloc:add:manager:list')")
	@ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名")})
	public ResponseResult addManagerAllocation(@RequestParam String username) {
		return allocationService.addAllocation(username, "manager");
	}

	@ApiOperation(value = "分配教师权限")
	@PostMapping("/alloc/add/teacher")
	@PreAuthorize("hasAuthority('system:alloc:add:teacher:list')")
	@ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名")})
	public ResponseResult addTeacherAllocation(@RequestParam String username) {
		return allocationService.addAllocation(username, "teacher");
	}

	@ApiOperation(value = "分配学生权限")
	@PostMapping("/alloc/add/student")
	@PreAuthorize("hasAuthority('system:alloc:add:student:list')")
	@ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名")})
	public ResponseResult addStudentAllocation(@RequestParam String username) {
		return allocationService.addAllocation(username, "student");
	}

	@ApiOperation(value = "删除管理员权限")
	@PostMapping("/alloc/delete/manager")
	@PreAuthorize("hasAuthority('system:alloc:delete:manager:list')")
	@ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名")})
	public ResponseResult deleteManagerAllocation(@RequestParam String username) {
		return allocationService.deleteAllocation(username, "manager");
	}

	@ApiOperation(value = "删除教师权限")
	@PostMapping("/alloc/delete/teacher")
	@PreAuthorize("hasAuthority('system:alloc:delete:teacher:list')")
	@ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名")})
	public ResponseResult deleteTeacherAllocation(@RequestParam String username) {
		return allocationService.deleteAllocation(username, "teacher");
	}

	@ApiOperation(value = "删除学生权限")
	@PostMapping("/alloc/delete/student")
	@PreAuthorize("hasAuthority('system:alloc:delete:student:list')")
	@ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名")})
	public ResponseResult deleteStudentAllocation(@RequestParam String username) {
		return allocationService.deleteAllocation(username, "student");
	}

}
