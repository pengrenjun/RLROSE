package com.emrubik.rose.modules.finshApprRemind.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.emrubik.entity.common.QueryReq;
import com.emrubik.entity.common.QueryResp;
import com.emrubik.entity.email.FinishApprRemindConfig;
import com.emrubik.rose.modules.emailUtils.EmailRemindService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @description: 完成审批提醒
 * @author: sunyingji
 * @create: 2019-04-17 15:55
 **/
@RestController
public class FinishApprController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());


    @Autowired
    private EmailRemindService emailRemindService;

    //邮件信息处理返回结果
    private static QueryResp queryResp=new QueryResp();


    @PostMapping("/v1.0/message/ApproveNotification")
    @ApiOperation(value = "审批完成提醒",notes = "根据流程id判断是否在邮件表中插入审批完成提醒邮件记录 ")
    public QueryResp finishApprRemind(@RequestBody @Valid QueryReq<FinishApprRemindConfig> finishApprRemindConfigs){

        logger.info("调用rose审批完成提醒邮件发送接口,传入邮件数据：{}", JSONObject.toJSONString(finishApprRemindConfigs));

        try {
            //校验流程ID在UEC_PMS_EMAIL_OID中是否存在,返回对应的oid
            emailRemindService.importRoseEmail(finishApprRemindConfigs.getData(), EmailRemindService.RoseEamilThemeTemplate.Approved);
            queryResp.setResult(true);
            queryResp.setMsg("成功");
        } catch (Exception e) {
            queryResp.setResult(false);
            queryResp.setMsg(" rose审批完成提醒邮件接口调用异常信息："+e.getMessage());
            logger.error("rose调用审批完成提醒邮件接口出现异常：{}",e.getMessage());
        }
        return  queryResp;
    }
}
