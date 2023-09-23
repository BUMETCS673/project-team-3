package com.teamthree.auth.tools;

import com.teamthree.model.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

public class BuildMenu {
    public static List<SysMenu> buildTree(List<SysMenu> sysMenuList) {
        List<SysMenu> trees = new ArrayList<>();
        for (SysMenu sysMenu : sysMenuList) {
            if(sysMenu.getParentId() == 0) {
                trees.add(findChildren(sysMenu,sysMenuList));
            }
        }
        return trees;
    }

    public static SysMenu findChildren(SysMenu sysMenu, List<SysMenu> treeNodes) {

        sysMenu.setChildren(new ArrayList<SysMenu>());

        for (SysMenu menu : treeNodes) {
            if(sysMenu.getId().longValue() == menu.getParentId().longValue()) {
                if (sysMenu.getChildren() == null) {
                    sysMenu.setChildren(new ArrayList<>());
                }
                sysMenu.getChildren().add(findChildren(menu,treeNodes));
            }
        }
        return sysMenu;
    }
}
