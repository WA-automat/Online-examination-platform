package com.csoep.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "role")
public class Role {

	@TableField(value = "id")
	@TableId(type = IdType.AUTO)
	private Integer id;

	@NonNull
	@TableField(value = "role_name")
	private String roleName;

	@NonNull
	@TableField(value = "role_key")
	private String roleKey;

	@NonNull
	@TableField(value = "status")
	private Integer status;

}
