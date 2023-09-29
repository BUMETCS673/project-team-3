package Employee_Management_System.result;

import lombok.Getter;

@Getter
public enum StatusCodeEnum {

    SUCCESS(200,"Success"),
    FAIL(201, "Fail"),
    SERVICE_ERROR(2012, "Service Error"),
    DATA_ERROR(204, "Data error"),

    LOGIN_AUTH(208, "Not log in "),
    PERMISSION(209, "No permission");

    private Integer code;

    private String message;
    private StatusCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
