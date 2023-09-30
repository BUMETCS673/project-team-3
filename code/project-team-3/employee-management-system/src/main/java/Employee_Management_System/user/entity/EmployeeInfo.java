package Employee_Management_System.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author godbro
 * @since 2023-09-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EmployeeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
      @TableId(value = "employee_id", type = IdType.AUTO)
    private Long employeeId;

    /**
     * 名字
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 岗位
     */
    private String jobTitle;

    /**
     * 工资
     */
    @TableField("AnnualSalary")
    private Long annualsalary;


}
