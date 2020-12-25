package com.xkcoding.exception.handler.controller;

import com.xkcoding.exception.handler.constant.Status;
import com.xkcoding.exception.handler.exception.JsonException;
import com.xkcoding.exception.handler.exception.PageException;
import com.xkcoding.exception.handler.exception.TestException;
import com.xkcoding.exception.handler.model.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 测试Controller
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-10-02 20:49
 */
@Controller
@Slf4j
public class TestController {

    @GetMapping("/json")
    @ResponseBody
    public ApiResponse jsonException() {
        throw new JsonException(Status.UNKNOWN_ERROR);
    }

    @GetMapping("/page")
    public ModelAndView pageException() {
        throw new PageException(Status.UNKNOWN_ERROR);
    }

    /**
     * 没有ExceptionHandler的异常
     * @return
     */
    @GetMapping("/test")
    @ResponseBody
    public ApiResponse testException() {
        throw new TestException(Status.UNKNOWN_ERROR);
    }


    /**
     * 统一 json 异常处理
     *
     * @param exception JsonException
     * @return 统一返回 json 格式
     */
    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public ApiResponse jsonErrorHandler(JsonException exception) {
        log.error("【优先级最高的异常处理】:{}", exception.getMessage());
        return ApiResponse.ofException(exception);
    }
}
