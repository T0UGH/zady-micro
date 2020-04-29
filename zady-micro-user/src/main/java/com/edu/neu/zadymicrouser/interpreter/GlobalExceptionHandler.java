package com.edu.neu.zadymicrouser.interpreter;

import com.edu.neu.zadymicrouser.pojo.DTO;
import com.edu.neu.zadymicrouser.util.DTOFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public DTO handleException(Exception e) {
        String msg = e.getMessage();
        logger.error(msg, e);
        msg = "服务器未知错误";
        return DTOFactory.unKnownErrorDTO(msg);
    }
}
