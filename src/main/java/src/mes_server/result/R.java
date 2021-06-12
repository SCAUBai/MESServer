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

    private Boolean success;

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<String, Object>();

    //把构造方法私有
    private R() {}

    //成功静态方法
    public static R ok() {
        R r = new R();
        r.setSuccess(true);
        r.setCode(20000);
        r.setMessage("成功");
        return r;
    }

    public static R ok(Object obj) {
        R r = ok();
        r.data(obj);
        return r;
    }

    //失败静态方法
    public static R error() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(20001);
        r.setMessage("失败");
        return r;
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

    public R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

    public R data(Object obj) {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            try {
                declaredField.setAccessible(true);
                String name = declaredField.getName();
                Object o = declaredField.get(obj);
                data.put(name, o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public static void main(String[] args) {
        Staff s = new Staff();
        s.setId(1);s.setPasswd("1");s.setPermissions(1);s.setWorks("2");
        R r = new R();
        r.data(s);
        Set<String> strings = r.data.keySet();
        for (String sq : strings) {
            System.out.println(sq + "," + r.data.get(sq));
        }
    }
}
