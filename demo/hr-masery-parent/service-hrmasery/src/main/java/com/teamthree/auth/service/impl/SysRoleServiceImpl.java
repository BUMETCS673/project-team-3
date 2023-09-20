package com.teamthree.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teamthree.auth.mapper.SysRoleMapper;
import com.teamthree.auth.service.SysRoleService;
import com.teamthree.model.system.SysRole;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}
