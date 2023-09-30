package Employee_Management_System.user.service.impl;

import Employee_Management_System.user.entity.EmployeeInfo;
import Employee_Management_System.user.mapper.EmployeeInfoMapper;
import Employee_Management_System.user.service.EmployeeInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author godbro
 * @since 2023-09-29
 */
@Service
public class EmployeeInfoServiceImpl extends ServiceImpl<EmployeeInfoMapper, EmployeeInfo> implements EmployeeInfoService {

}
