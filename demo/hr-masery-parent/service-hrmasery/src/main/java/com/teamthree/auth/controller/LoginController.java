package com.teamthree.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.teamthree.auth.service.SysMenuService;
import com.teamthree.auth.service.SysUserService;
import com.teamthree.common.exception.CustomException;
import com.teamthree.common.exception.GlobalExceptionHandler;
import com.teamthree.common.jwt.JwtHelper;
import com.teamthree.common.result.Result;
import com.teamthree.common.utils.MD5;
import com.teamthree.model.system.SysUser;
import com.teamthree.vo.system.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "Background Login Management")
@RestController
@RequestMapping("/admin/system/index")
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation(value = "登录接口")
    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo) {
        String username = loginVo.getUsername();
        String password = loginVo.getPassword();

        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername,username);
        SysUser sysUser= sysUserService.getOne(wrapper);

        if(sysUser == null){
            throw new CustomException(200,"user not exist");
        }


        String password_db = sysUser.getPassword();
        String password_loginVo = MD5.encrypt(password);
        if(!password_db.equals(password_loginVo)) {
            throw new CustomException(201,"Incorrect password");
        }

        // 状态（1：正常 0：停用）
        if(sysUser.getStatus()==0) {
            throw new CustomException(202,"The user has been disabled");
        }

        //6 使用jwt根据用户id和用户名称生成token字符串
        String token = JwtHelper.createToken(sysUser.getId(), sysUser.getUsername());
        //7 返回
        Map<String,Object> map = new HashMap<>();
        map.put("token",token);
        return Result.ok(map);
    }

    @PostMapping("/logout")
    public Result logout(){
        return Result.ok();
    }


}
