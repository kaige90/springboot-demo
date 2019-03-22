package com.chenkai.springbootdemo.demo.controller;

import com.chenkai.springbootdemo.demo.exception.CommonException;
import com.chenkai.springbootdemo.demo.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.OK;


/**
 * 全局异常拦截
 *
 * @author: chenkai
 * @since: 2018/4/9.
 */
@ControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 通用异常，打印错误栈
     *
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class, NullPointerException.class})
    @ResponseBody
    public Result runtimeExceptionHandler(Exception e) {
        logger.info("通用异常拦截...");
        Result result = new Result();
        result.setFalse();
        result.setMessage("系统异常，请稍后再试～");
        logger.error(e.getLocalizedMessage(), e);
        return result;
    }

    /**
     * 只读异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler({IllegalArgumentException.class, CommonException.class})
    @ResponseBody
    public Result readMessageException(CommonException e) {
        Result result = new Result();
        result.setFalse();
        result.setMessage(e.getMessage());
        return result;
    }

    /**
     * 执行RequestMapping的异常，参数错误，方法不对等
     *
     * @param ex
     * @param body
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Result result = new Result();
        result.setFalse();
        result.setMessage(ex.getMessage());
        return new ResponseEntity<>(result, OK);
    }
}
