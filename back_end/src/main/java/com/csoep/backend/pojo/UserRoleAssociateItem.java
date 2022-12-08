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

	@TableField(value = "id")
	@TableId(type = IdType.AUTO)
	private Integer id;

	@NonNull
	@TableField(value = "user_id")
	private Integer userId;

	@NonNull
	@TableField(value = "role_id")
	private Integer roleId;

}
