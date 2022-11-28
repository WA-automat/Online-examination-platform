package com.csoep.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * 连接数据库
 * 用户的pojo层
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user")
public class User {

	/**
	 * 用户id
	 * 作为该数据表的主键
	 * 用于唯一标识一个用户
	 * 该变量是非空的并且具有自增的性质
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/**
	 * 用户名：用户自己拟定
	 * 也可以唯一标识一个用户
	 * 是非空的
	 */
	@NonNull
	private String username;

	/**
	 * 用户密码
	 * 是非空的
	 */
	@NonNull
	private String password;

	/**
	 * 用户的电子邮箱
	 * 是非空的
	 */
	@NonNull
	private String email;

	/**
	 * 用户的电话号码
	 * 是非空的
	 */
	@NonNull
	private String phone;
}
