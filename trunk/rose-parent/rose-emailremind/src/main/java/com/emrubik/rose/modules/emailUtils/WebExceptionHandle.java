package com.emrubik.rose.modules.emailUtils;

import com.emrubik.entity.common.QueryResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO
 * @Date 2019/4/17 0017 下午 3:19
 * @Created by Pengrenjun
 */
@ControllerAdvice
@ResponseBody
public class WebExceptionHandle {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public QueryResp validExceptionHandle(MethodArgumentNotValidException m){

        QueryResp queryResp = new QueryResp();
        queryResp.setResult(false);
        queryResp.setMsg(m.getBindingResult().getFieldError().
                getDefaultMessage());

        logger.error("邮件接口参数传入校验异常:{}",m.getMessage());
        return queryResp;
    }
}
