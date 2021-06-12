package src.mes_server.result;

import lombok.Data;

@Data
public class UserNotFoundException extends RuntimeException{
    private Integer code;//状态码
    private String msg;//异常信息

    public UserNotFoundException(String msg) {
        super(msg);
        this.code = 1000;
        this.msg = msg;
    }
}
