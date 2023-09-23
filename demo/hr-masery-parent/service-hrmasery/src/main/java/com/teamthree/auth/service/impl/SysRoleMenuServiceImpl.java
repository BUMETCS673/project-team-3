package com.teamthree.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teamthree.auth.mapper.SysMenuMapper;
import com.teamthree.auth.mapper.SysRoleMenuMapper;
import com.teamthree.auth.service.SysMenuService;
import com.teamthree.auth.service.SysRoleMenuService;
import com.teamthree.model.system.SysMenu;
import com.teamthree.model.system.SysRoleMenu;
import org.springframework.stereotype.Service;

@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {
}
