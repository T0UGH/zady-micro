package com.edu.neu.zadymicroreport.interperter;

import com.edu.neu.zadymicroreport.exception.DegradeException;
import com.edu.neu.zadymicroreport.pojo.DTO;
import com.edu.neu.zadymicroreport.util.DTOFactory;
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
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(DegradeException.class)
    public DTO handleDegradeException(Exception e) {
        String msg = e.getMessage();
        logger.error(msg, e);
        return DTOFactory.degradeDTO(msg);
    }

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
