package Employee_Management_System.credential.service;

import Employee_Management_System.credential.entity.UserCredential;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 身份表 服务类
 * </p>
 *
 * @author godbro
 * @since 2023-09-29
 */
public interface UserCredentialService extends IService<UserCredential> {

    UserCredential getUserByUserName(String username);

}
