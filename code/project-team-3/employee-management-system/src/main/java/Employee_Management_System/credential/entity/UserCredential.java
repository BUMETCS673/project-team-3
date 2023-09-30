package Employee_Management_System.credential.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 身份表
 * </p>
 *
 * @author godbro
 * @since 2023-09-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserCredential implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
      @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;


}
