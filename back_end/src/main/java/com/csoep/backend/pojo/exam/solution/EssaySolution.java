package com.csoep.backend.pojo.exam.solution;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * 问答题存储类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "essay_solution")
public class EssaySolution {

	@TableId(type = IdType.AUTO)
	private Integer id;

	@NonNull
	@TableField(value = "exam_id")
	private Integer examId;

	@NonNull
	@TableField(value = "choice_id")
	private Integer choiceId;

	@NonNull
	@TableField(value = "user_id")
	private Integer userId;

	@NonNull
	@TableField(value = "solution")
	private String solution;

}
