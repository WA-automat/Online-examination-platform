package com.csoep.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * 连接数据库
 * 权限的pojo层
 * 权限信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "menu")
public class Menu implements Serializable {

	private static final long serialVersionUID = -54979041104113736L;

	/**
	 * 权限id
	 * 主键
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/**
	 * 权限名
	 */
	@NonNull
	@TableField(value = "menu_name")
	private String menuName;

	/**
	 * 权限字段
	 * 用于定位权限
	 */
	@NonNull
	@TableField(value = "perms")
	private String perms;

	/**
	 * 状态码
	 * 决定权限是否被弃用
	 */
	@TableField(value = "status")
	private Integer status;

	/**
	 * 权限路径
	 */
	@NonNull
	@TableField(value = "path")
	private String path;

	/**
	 * 组件路径
	 */
	@NonNull
	@TableField(value = "component")
	private String component;

}
