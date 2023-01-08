package com.csoep.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csoep.backend.pojo.exam.Choice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChoiceMapper extends BaseMapper<Choice> {
}
