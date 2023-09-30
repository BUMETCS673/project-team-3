package Employee_Management_System.user.controller;


import Employee_Management_System.result.Result;
import Employee_Management_System.user.entity.EmployeeInfo;
import Employee_Management_System.user.service.EmployeeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author godbro
 * @since 2023-09-29
 */

@Api(tags = "User Management ")
@RestController
@RequestMapping("/admin/system/user")
public class EmployeeInfoController {

    @Autowired
    private EmployeeInfoService employeeInfoService;

    
    @ApiOperation(value = "获取用户")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable Long id) {
        EmployeeInfo employee  = employeeInfoService.getById(id);
        return Result.ok(employee);
    }

    @ApiOperation(value = "保存用户")
    @PostMapping("/save")
    public Result save(@RequestBody EmployeeInfo employeeInfo) {
        employeeInfoService.save(employeeInfo);
        return Result.ok();
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("/update")
    public Result updateById(@RequestBody EmployeeInfo employeeInfo) {
        employeeInfoService.updateById(employeeInfo);
        return Result.ok();
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable Long id) {
        employeeInfoService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "批量删除用户")
    @DeleteMapping("/deleteBatch")
    public Result batchRemove(@RequestBody List<Long> idList) {
        employeeInfoService.removeByIds(idList);
        return Result.ok();
    }



}

