package com.teamthree.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.teamthree.model.system.SysMenu;
import com.teamthree.model.system.SysRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
}
