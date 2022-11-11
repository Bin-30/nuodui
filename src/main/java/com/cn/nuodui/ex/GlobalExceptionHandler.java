package com.cn.nuodui.ex;

import com.cn.nuodui.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public JsonResult<Void> handleServiceException(ServiceException e){
        return JsonResult.fail(e);
    }

    @ExceptionHandler
    public JsonResult<Void> handleThrowable(Throwable e){
        String message = "系统错误，请联系系统管理员";
        return JsonResult.fail(message,500);
    }
}
