package com.jigu.loan.handler;


import com.samecity.common.http.JsonResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.samecity.common.constaint.CodeConstaint.*;


/**
 * 统一异常处理
 */
@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private JsonResult handleException(RuntimeException ex){
        System.out.printf(ex.getLocalizedMessage());
        return JsonResult.createError("操作失败", SYS_ERROR);
    }
}
