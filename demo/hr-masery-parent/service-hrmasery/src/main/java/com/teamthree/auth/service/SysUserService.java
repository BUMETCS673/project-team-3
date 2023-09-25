package com.teamthree.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.teamthree.model.system.SysUser;

public interface SysUserService extends IService<SysUser> {
    void updateStatus(Long id, Integer status);

    SysUser getUserByUserName(String username);
}
