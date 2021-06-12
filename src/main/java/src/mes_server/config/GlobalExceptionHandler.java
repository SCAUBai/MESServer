package src.mes_server.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import src.mes_server.result.PasswdFailException;
import src.mes_server.result.R;
import src.mes_server.result.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        return R.error().message("执行了全局异常处理..");
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常处理..");
    }

    @ExceptionHandler(PasswdFailException.class)
    @ResponseBody
    public R error(PasswdFailException e) {
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    public R error(UserNotFoundException e) {
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }

}
