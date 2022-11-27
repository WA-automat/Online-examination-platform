package com.csoep.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csoep.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用于连接User实体类的Mapper
 * 实现基本增删改查操作的函数
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
