package src.mes_server.utils;

import src.mes_server.result.ResultEnum;

public class ResultUtil {

    public static ResultEnum returnString(int predict, int real, String base) {
        return predict == real ? ResultEnum.SUCCESS : getEnum(base);
    }

    public static ResultEnum returnString(int real, String base) {
        return real > 0 ? ResultEnum.SUCCESS : getEnum(base);
    }

    static ResultEnum getEnum(String base) {
        String name = base + "_FAIL";
        Class clazz = ResultEnum.class;
        Object[] enumConstants = clazz.getEnumConstants();
        for (Object o : enumConstants) {
            if (name.equals(o.toString())) {
                return (ResultEnum) o;
            }
        }
        return null;
    }
}
