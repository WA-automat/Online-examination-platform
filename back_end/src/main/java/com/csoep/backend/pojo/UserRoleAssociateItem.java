package com.csoep.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * 用户角色关联表
 * 实体类
 * 代表一个关联元组
 */
@TableName(value = "sys_user_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleAssociateItem {

	/**
	 * 元组id
	 * 主键
	 */
	@TableField(value = "id")
	@TableId(type = IdType.AUTO)
	private Integer id;

	/**
	 * 关联的用户id
	 */
	@NonNull
	@TableField(value = "user_id")
	private Integer userId;

	/**
	 * 关联的角色id
	 */
	@NonNull
	@TableField(value = "role_id")
	private Integer roleId;

}
