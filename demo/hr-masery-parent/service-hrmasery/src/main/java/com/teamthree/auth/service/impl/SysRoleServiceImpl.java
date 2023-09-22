package com.teamthree.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teamthree.auth.mapper.SysRoleMapper;
import com.teamthree.auth.service.SysRoleService;
import com.teamthree.auth.service.SysUserRoleService;
import com.teamthree.model.system.SysRole;
import com.teamthree.model.system.SysUserRole;
import com.teamthree.vo.system.AssginRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    public Map<String, Object> getRoleListByUserid(Long userId) {

        List<SysRole> sysRoleList = baseMapper.selectList(null);

        LambdaQueryWrapper<SysUserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUserRole::getUserId, userId);
        List<SysUserRole> existUserRolelist = sysUserRoleService.list(wrapper);

        List<Long> existRoleIdlist = new ArrayList<>();
        for(SysUserRole userRole : existUserRolelist) {
            Long roleId = userRole.getRoleId();
            existRoleIdlist.add(roleId);
        }

        List<SysRole> assignRoleList = new ArrayList<>();

        for(SysRole sysRole : sysRoleList) {
            if(existRoleIdlist.contains(sysRole.getId())) {
                assignRoleList.add(sysRole);
            }
        }

        Map<String, Object> roleMap = new HashMap<>();
        roleMap.put("assginRoleList", assignRoleList);
        roleMap.put("allRolesList", sysRoleList);
        return roleMap;
    }

    @Override
    public void toAssign(AssginRoleVo assginRoleVo) {
        LambdaQueryWrapper<SysUserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUserRole::getUserId,assginRoleVo.getUserId());
        sysUserRoleService.remove(wrapper);

        List<SysRole> newRoleIdList  = new ArrayList<>();
        for(Long roleId : assginRoleVo.getRoleIdList()) {
            if(StringUtils.isEmpty(roleId))
                continue;
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(assginRoleVo.getUserId());
            userRole.setRoleId(roleId);
            sysUserRoleService.save(userRole);
        }
    }
}
