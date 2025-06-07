package com.cgr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cgr.entity.CPUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<CPUser> {
}
