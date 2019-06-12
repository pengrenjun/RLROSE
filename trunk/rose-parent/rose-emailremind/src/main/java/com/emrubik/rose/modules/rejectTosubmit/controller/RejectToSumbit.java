package com.emrubik.rose.modules.rejectTosubmit.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.emrubik.entity.common.QueryReq;
import com.emrubik.entity.common.QueryResp;
import com.emrubik.entity.email.RejectToSubmitRemindConfig;
import com.emrubik.entity.email.TodoRemindConfig;
import com.emrubik.rose.modules.emailUtils.EmailRemindService;
import com.emrubik.rosemail.generator.dao.PmsEmailOidPoMapper;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Description 驳回提醒-提交人邮件信息导入接口
 * @Date 2019/4/17 0017 上午 10:23
 * @Created by Pengrenjun
 */
@RestController
public class RejectToSumbit {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PmsEmailOidPoMapper pmsEmailOidPoMapper;

    @Autowired
    private EmailRemindService emailRemindService;

    //邮件信息处理返回结果
    private static QueryResp queryResp=new QueryResp();

    /**
     * 驳回提醒-提交人邮件信息接收并导入数据库
     * @param emailparams
     * @return
     */
    @PostMapping ("/v1.0/message/rejectToSubmitterNotification")
    @ApiOperation(value = "驳回提醒-提交人",notes = "根据流程id判断是否在邮件表中插入邮件记录 ")
    public QueryResp rejectToSumbitMails(@RequestBody @Valid QueryReq<RejectToSubmitRemindConfig>  emailparams){

        logger.info("调用rose驳回提醒-提交人邮件发送接口,传入邮件数据：{}", JSONObject.toJSONString(emailparams));
        try {
            //校验流程ID在UEC_PMS_EMAIL_OID中是否存在,返回对应的oid
            emailRemindService.importRoseEmail(emailparams.getData(),EmailRemindService.RoseEamilThemeTemplate.RejectToSubmit);
            queryResp.setResult(true);
            queryResp.setMsg("成功");
        } catch (Exception e) {
            queryResp.setResult(false);
            queryResp.setMsg("rose驳回提醒-提交人邮件接口调用异常信息："+e.getMessage());
            logger.error("rose调用驳回提醒-提交人邮件接口出现异常：{}",e.getMessage());
        }
        return  queryResp;
    }


}
