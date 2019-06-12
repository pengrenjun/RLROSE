package com.emrubik.rose.modules.todoremind.controller;

import com.alibaba.fastjson.JSONObject;
import com.emrubik.entity.common.QueryReq;
import com.emrubik.entity.common.QueryResp;
import com.emrubik.entity.email.TodoRemindConfig;
import com.emrubik.rose.modules.emailUtils.EmailRemindService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 待办提醒接口
 * @author: sunyingji
 * @create: 2019-04-17 10:01
 **/
@RestController
public class TodoRemindController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmailRemindService emailRemindService;

    //邮件信息处理返回结果
    private static QueryResp queryResp=new QueryResp();

     @PostMapping("/v1.0/message/backlogNotification")
     @ApiOperation(value = "待办提醒",notes = "根据流程id判断是否在邮件表中插入邮件记录 ")
     public QueryResp todoRemind(@RequestBody @Valid  QueryReq<TodoRemindConfig> todoRemindConfigs ){

         logger.info("调用rose待办提醒邮件发送接口,传入邮件数据：{}", JSONObject.toJSONString(todoRemindConfigs));

         try {
             //校验流程ID在UEC_PMS_EMAIL_OID中是否存在,返回对应的oid
             emailRemindService.importRoseEmail(todoRemindConfigs.getData(),EmailRemindService.RoseEamilThemeTemplate.Todo);
             queryResp.setResult(true);
             queryResp.setMsg("成功");
         } catch (Exception e) {
             queryResp.setResult(false);
             queryResp.setMsg("rose待办提醒邮件接口调用异常信息："+e.getMessage());
             logger.error("rose调用待办提醒邮件接口出现异常：{}",e.getMessage());
         }
         return  queryResp;
     }

}
