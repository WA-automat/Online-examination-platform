package com.csoep.backend.pojo.exam;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "exam")
public class Exam {

	/**
	 * 考试的唯一标识
	 * 作为主键
	 */
	@TableId(type = IdType.AUTO)
	@TableField(value = "id")
	private Integer id;

	/**
	 * 考试的名称
	 * 全称
	 */
	@NonNull
	@TableField(value = "exam_name")
	private String examName;

	/**
	 * 考试起始时间
	 */
	@NonNull
	@TableField(value = "start_time")
	private Date startTime;

	/**
	 * 考试结束时间
	 */
	@NonNull
	@TableField(value = "end_time")
	private Date endTime;

	/**
	 * 考试类型
	 * 0：公开
	 * 1：私有(有邀请码才能访问)
	 */
	@TableField(value = "type")
	private Integer type;

	/**
	 * 邀请码
	 */
	@TableField(value = "invite_code")
	private String inviteCode;

	/**
	 * 题目数
	 */
	@NonNull
	@TableField(value = "question_num")
	private Integer questionNumber;
}
