package Employee_Management_System.credential.service.impl;

import Employee_Management_System.credential.entity.UserCredential;
import Employee_Management_System.credential.mapper.UserCredentialMapper;
import Employee_Management_System.credential.service.UserCredentialService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 身份表 服务实现类
 * </p>
 *
 * @author godbro
 * @since 2023-09-29
 */
@Service
public class UserCredentialServiceImpl extends ServiceImpl<UserCredentialMapper, UserCredential> implements UserCredentialService {

    @Override
    public UserCredential getUserByUserName(String username) {
        LambdaQueryWrapper<UserCredential> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserCredential::getUsername, username);
        UserCredential userCredential = baseMapper.selectOne(wrapper);
        return userCredential;
    }
}
