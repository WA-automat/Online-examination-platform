package com.csoep.backend.pojo.exam;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * 问答题
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "essay_question")
public class Essay {

	@TableId(type = IdType.AUTO)
	private Integer id;

	@NonNull
	@TableField(value = "exam_id")
	private Integer examId;

	@NonNull
	@TableField(value = "question")
	private String question;

}
