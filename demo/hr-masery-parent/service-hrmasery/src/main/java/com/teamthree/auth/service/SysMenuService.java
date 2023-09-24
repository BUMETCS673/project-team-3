package com.teamthree.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.teamthree.model.system.SysMenu;
import com.teamthree.model.system.SysRole;
import com.teamthree.vo.system.AssignMenuVo;
import com.teamthree.vo.system.RouterVo;

import java.util.List;

public interface SysMenuService extends IService<SysMenu> {
    List<SysMenu> findNodes();

    List<SysMenu> findSysMenuByRoleId(Long roleId);

    void doAssign(AssignMenuVo assignMenuVo);


    List<SysMenu> findUserMenuByUserId(Long userId);

    List<String> findUserPermByUserId(Long userId);
}
