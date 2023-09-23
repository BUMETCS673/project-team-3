package com.teamthree.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teamthree.auth.mapper.SysMenuMapper;
import com.teamthree.auth.service.SysMenuService;
import com.teamthree.auth.service.SysRoleMenuService;
import com.teamthree.auth.tools.BuildMenu;
import com.teamthree.model.system.SysMenu;
import com.teamthree.model.system.SysRoleMenu;
import com.teamthree.vo.system.AssignMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @Override
    public List<SysMenu> findNodes() {
        List<SysMenu> sysMenuList = baseMapper.selectList(null);
        if(CollectionUtils.isEmpty(sysMenuList)) {
            return null;
        }else {
            List<SysMenu> result = BuildMenu.buildTree(sysMenuList);
            return result;
        }
    }

    @Override
    public List<SysMenu> findSysMenuByRoleId(Long roleId) {

        LambdaQueryWrapper<SysMenu> menuWrapper = new LambdaQueryWrapper<>();
        menuWrapper.eq(SysMenu::getStatus,1);

        // available perm for the Sys-menu
        List<SysMenu> allSysMenuList = baseMapper.selectList(menuWrapper);

        // 根据roleid去查询数据库对应的sysrolemenu对象
        LambdaQueryWrapper<SysRoleMenu> roleWrapper = new LambdaQueryWrapper<SysRoleMenu>();
        roleWrapper.eq(SysRoleMenu::getRoleId,roleId);
        List<SysRoleMenu> sysRoleMenuList= sysRoleMenuService.list(roleWrapper);

        List<Long> menuIdList = new ArrayList<>();
        for(SysRoleMenu roleMenu:sysRoleMenuList) {
            Long menuId = roleMenu.getMenuId();
            menuIdList.add(menuId);
        }

        for (SysMenu sysMenu: allSysMenuList) {
            if(menuIdList.contains(sysMenu.getId())){
                sysMenu.setSelect(true);
            }else{
                sysMenu.setSelect(false);
            }
        }

        List<SysMenu> sysMenuList = BuildMenu.buildTree(allSysMenuList);
        return sysMenuList;
        //<==    Output like :
        //           Columns: id, role_id, menu_id, create_time, update_time, is_deleted
        //<==        Row: 33, 8, 3, 2023-09-23 12:40:34, 2023-09-23 13:14:58, 0
        //<==        Row: 34, 8, 6, 2023-09-23 12:40:34, 2023-09-23 14:05:01, 0
        //<==        Row: 35, 8, 7, 2023-09-23 12:40:34, 2023-09-23 14:05:01, 0
        //<==        Total: 3
    }

    @Override
    public void doAssign(AssignMenuVo assignMenuVo) {
        LambdaQueryWrapper<SysRoleMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRoleMenu::getRoleId,assignMenuVo.getRoleId());
        sysRoleMenuService.remove(wrapper);

        List<Long> menuIdList = assignMenuVo.getMenuIdList();
        for(Long menuId:menuIdList) {
            if(StringUtils.isEmpty(menuId)) {
                continue;
            }
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setMenuId(menuId);
            sysRoleMenu.setRoleId(assignMenuVo.getRoleId());
            sysRoleMenuService.save(sysRoleMenu);
        }
    }
}
