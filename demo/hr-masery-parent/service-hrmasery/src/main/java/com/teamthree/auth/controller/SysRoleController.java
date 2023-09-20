package com.teamthree.auth.controller;

import com.teamthree.auth.service.SysRoleService;
import com.teamthree.model.system.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/findAll")
    public List<SysRole> findAll() {
        List<SysRole> roleList = sysRoleService.list();
        return roleList;
    }

    @PostMapping("/save")
    public Boolean save(@RequestBody SysRole role) {
        return sysRoleService.save(role);
    }

    @GetMapping("/get/{id}")
    public SysRole get(@PathVariable Long id) {
        return sysRoleService.getById(id);
    }

    @PutMapping("/update")
    public Boolean updateById(@RequestBody SysRole role) {
       return sysRoleService.updateById(role);
    }

    @DeleteMapping("/remove/{id}")
    public Boolean remove(@PathVariable Long id) {
        return sysRoleService.removeById(id);
    }

    @DeleteMapping("/deleteBatch")
    public Boolean batchRemove(@RequestBody List<Long> idList) {
        return sysRoleService.removeByIds(idList);
    }
}
