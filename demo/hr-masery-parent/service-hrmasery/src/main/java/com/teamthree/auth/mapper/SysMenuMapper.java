package com.teamthree.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.teamthree.model.system.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    List<SysMenu> findListByUserId(@Param("userId") Long userId);
}
