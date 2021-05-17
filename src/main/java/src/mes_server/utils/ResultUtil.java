package src.mes_server.utils;

import java.security.SecureRandom;

public class ResultUtil {
    private static final String success = "true";
    private static final String fail = "false";

    public static String returnString(int predict, int real) {
        return predict == real ? success : fail;
    }

    public static String returnString(int real) {
        return real > 0 ? success : fail;
    }
}
