package src.mes_server.result;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ResultEnum {
    SUCCESS("200", "success"),
    SELECT_FAIL("404","查不到相应资源"),
    DELETE_FAIL("405", "资源不存在或删除失败"),
    UPDATE_FAIL("406", "资源不存在或更新失败"),
    INSERT_FAIL("407", "资源已存在或插入失败");
    private String code;
    private String defaultMessage;


    ResultEnum(String code, String defaultMessage) {
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
}
