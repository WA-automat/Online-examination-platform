package com.csoep.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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

	@TableId(type = IdType.AUTO)
	private Integer id;

	@NonNull
	@TableField(value = "menu_name")
	private String menuName;

	@NonNull
	@TableField(value = "perms")
	private String perms;

	@NonNull
	@TableField(value = "status")
	private Integer status;

	@NonNull
	@TableField(value = "path")
	private String path;

	@NonNull
	@TableField(value = "component")
	private String component;

}
