package src.mes_server.result;

import lombok.Data;

@Data
public class PasswdFailException extends RuntimeException{
    private Integer code;//状态码
    private String msg;//异常信息

    public PasswdFailException(String msg) {
        super(msg);
        this.code = 1001;
        this.msg = msg;
    }
}
