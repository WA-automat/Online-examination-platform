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
 * 角色数据库实体类
 * 角色的pojo层
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "role")
public class Role {

	/**
	 * 角色id
	 * 主键
	 */
	@TableField(value = "id")
	@TableId(type = IdType.AUTO)
	private Integer id;

	/**
	 * 角色名称
	 * 非空
	 */
	@NonNull
	@TableField(value = "role_name")
	private String roleName;

	/**
	 * 角色键
	 * 用于用户定位角色
	 */
	@NonNull
	@TableField(value = "role_key")
	private String roleKey;

	/**
	 * 状态码
	 * 表示角色是否被弃用
	 */
	@NonNull
	@TableField(value = "status")
	private Integer status;

}
