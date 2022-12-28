package com.csoep.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csoep.backend.mapper.UserMapper;
import com.csoep.backend.pojo.User;
import com.csoep.backend.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 就是一个测试类而已
 * 没有什么实际作用
 * 调用其中的hello方法返回一个列表
 * 列表内容是所有用户信息
 */
@Api(value = "测试API")
@RestController
public class HelloController {

	@Autowired
	private UserMapper userMapper;

	@ApiOperation(value = "测试接口")
	@RequestMapping("/hello")
	@PreAuthorize("hasAuthority('system:test:list')")
	public ResponseResult hello() {
		Map<String, String> map = new HashMap<>();
		map.put("state", "success");
		map.put("test", "test");
		return new ResponseResult(200, "测试成功", map);
	}

}
