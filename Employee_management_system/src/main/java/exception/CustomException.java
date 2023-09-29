package exception;

import Employee_Management_System.result.StatusCodeEnum;
import lombok.Data;

@Data
public class CustomException extends RuntimeException{

    private Integer code;
    private String msg;

    public CustomException(Integer code,String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }


    public CustomException(StatusCodeEnum statusCodeEnum) {
        super(statusCodeEnum.getMessage());
        this.code = statusCodeEnum.getCode();
        this.msg = statusCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "CustomException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
