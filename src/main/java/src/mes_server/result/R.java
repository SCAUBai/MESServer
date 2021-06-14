package src.mes_server.result;

import lombok.Data;
import src.mes_server.pojo.Staff;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//统一返回结果的类
@Data
public class R {
    private static final int SUCCESS = 200;
    public static final int FAILED = 500;
    public static final int UNAUTHORIZED = 401;
    public static final int VALIDATE_FAILED = 404;

    private Boolean success;
    private Integer code;
    private String message;
    private Object data;
    private R() {}

    //成功静态方法
    public static R ok() {
        return ok(null);
    }

    public static R ok(Object data) {
        return new R().success(true).code(SUCCESS).message("成功").data(data);
    }

    //失败静态方法
    public static R error() {
        return error(null);
    }

    public static R error(Object data) {
        R r = new R();
        r.setSuccess(false);
        r.setCode(FAILED);
        r.setMessage("失败");
        r.setData(data);
        return new R().success(false).code(FAILED).message("失败").data(data);
    }

    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R data(Object data){
        this.setData(data);
        return this;
    }

//    public R data(Object obj) {
//        Field[] declaredFields = obj.getClass().getDeclaredFields();
//        for (Field declaredField : declaredFields) {
//            try {
//                declaredField.setAccessible(true);
//                String name = declaredField.getName();
//                Object o = declaredField.get(obj);
//                data.put(name, o);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//        return this;
//    }
}
