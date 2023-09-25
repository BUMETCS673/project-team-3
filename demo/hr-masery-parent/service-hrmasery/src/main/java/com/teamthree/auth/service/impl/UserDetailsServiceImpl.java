package com.teamthree.auth.service.impl;

import com.teamthree.auth.service.SysMenuService;
import com.teamthree.auth.service.SysUserService;
import com.teamthree.model.system.SysUser;
import com.teamthree.security.customcomponent.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser = sysUserService.getUserByUserName(username);

        if(null == sysUser) {
            throw new UsernameNotFoundException("User does not exist");
        }

        if(sysUser.getStatus() == 0) {
            throw new RuntimeException("Account Deactivated");
        }

//        // 查询权限信息
//        List<String> userPermsList = sysMenuService.findUserPermByUserId(sysUser.getId());
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        for (String perm : userPermsList) {
//            authorities.add(new SimpleGrantedAuthority(perm.trim()));
//        }

        return new CustomUser(sysUser, Collections.emptyList());
    }

}
