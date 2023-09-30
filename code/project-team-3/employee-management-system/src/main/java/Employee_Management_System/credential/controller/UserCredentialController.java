package Employee_Management_System.credential.controller;


import Employee_Management_System.credential.entity.UserCredential;
import Employee_Management_System.credential.service.UserCredentialService;
import Employee_Management_System.exception.CustomException;
import Employee_Management_System.jwt.JwtHelper;
import Employee_Management_System.result.Result;
import Employee_Management_System.utils.MD5;
import Employee_Management_System.vo.LoginVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 身份表 前端控制器
 * </p>
 *
 * @author godbro
 * @since 2023-09-29
 */
@Api(tags = "身份管理 ")
@RestController
@RequestMapping("/admin/system/credential")
public class UserCredentialController {

    @Autowired
    private UserCredentialService userCredentialService;

    @ApiOperation(value = "登录接口")
    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo) {
        String username = loginVo.getUsername();
        String password = loginVo.getPassword();

        LambdaQueryWrapper<UserCredential> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserCredential::getUsername, username);
        UserCredential user = userCredentialService.getOne(wrapper);

        if (user == null) {
            throw new CustomException(200, "user not exist");
        }

        String password_db = user.getPassword();
        String password_loginVo = MD5.encrypt(password);
        if(!password_db.equals(password_loginVo)) {
            throw new CustomException(201,"Incorrect password");
        }

        String token = JwtHelper.createToken(user.getUserId(), user.getUsername());

        //返回
        Map<String,Object> map = new HashMap<>();
        map.put("token",token);
        return Result.ok(map);
    }

    @PostMapping("/create-account")
    public Result handleCreateAccount(@RequestBody UserCredential userCredential) {
        String passwordWithMD5 = MD5.encrypt(userCredential.getPassword());
        userCredential.setPassword(passwordWithMD5);
        userCredentialService.save(userCredential);
        return Result.ok();
    }

}

