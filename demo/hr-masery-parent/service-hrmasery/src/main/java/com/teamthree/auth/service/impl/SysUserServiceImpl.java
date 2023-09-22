package com.teamthree.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teamthree.auth.mapper.SysRoleMapper;
import com.teamthree.auth.mapper.SysUserMapper;
import com.teamthree.auth.service.SysRoleService;
import com.teamthree.auth.service.SysUserService;
import com.teamthree.model.system.SysRole;
import com.teamthree.model.system.SysUser;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Override
    public void updateStatus(Long id, Integer status) {
        SysUser sysUser = baseMapper.selectById(id);
        if(status == 1) {
            sysUser.setStatus(status);
        } else {
            sysUser.setStatus(0);
        }
        this.updateById(sysUser);
    }
}
