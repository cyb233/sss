package moe.shuvi.exception;

import moe.shuvi.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author Administrator
 * @Date: 2021/12/20 13:47
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    public Result respError(Exception e){
        //写日志
        LOGGER.error("业务异常", e);
        Result result = new Result();
        result.setCode(Result.CODE_ERROR);
        result.setMsg(Result.MSG_ERROR);
        return result;
    }
}
