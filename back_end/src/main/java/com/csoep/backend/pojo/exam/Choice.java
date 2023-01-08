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
 * 选择题
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "choice_question")
public class Choice {

	@TableId(type = IdType.AUTO)
	private Integer id;

	@NonNull
	@TableField(value = "exam_id")
	private Integer examId;

	@NonNull
	@TableField(value = "type")
	private Integer type;

	@NonNull
	@TableField(value = "question")
	private String question;

	@NonNull
	@TableField(value = "A_describe")
	private String aDescribe;

	@NonNull
	@TableField(value = "B_describe")
	private String bDescribe;

	@NonNull
	@TableField(value = "C_describe")
	private String cDescribe;

	@NonNull
	@TableField(value = "D_describe")
	private String dDescribe;

	@NonNull
	@TableField(value = "solution")
	private String solution;

}
