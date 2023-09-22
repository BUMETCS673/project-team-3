package com.teamthree.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.teamthree.model.system.SysRole;
import com.teamthree.vo.system.AssginRoleVo;

import java.util.Map;

public interface SysRoleService extends IService<SysRole> {

    Map<String, Object> getRoleListByUserid(Long userId);

    void toAssign(AssginRoleVo assginRoleVo);
}
