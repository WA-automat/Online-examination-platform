package com.csoep.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csoep.backend.pojo.UserRoleAssociateItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AssociateItemMapper extends BaseMapper<UserRoleAssociateItem> {
}
