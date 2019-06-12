package com.emrubik.rose.modules.emailUtils;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.emrubik.entity.email.*;
import com.emrubik.rose.modules.emailUtils.mapper.UecPmsMailMapper;
import com.emrubik.rosemail.generator.dao.PmsEmailOidPoMapper;
import com.emrubik.rosemail.generator.dao.PssEmailPoMapper;
import com.emrubik.rosemail.generator.dao.bean.PmsEmailOidPo;
import com.emrubik.rosemail.generator.dao.bean.PmsEmailOidPoExample;
import com.emrubik.rosemail.generator.dao.bean.PssEmailPo;
import com.emrubik.rosemail.generator.dao.bean.PssEmailPoExample;
import org.assertj.core.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description 邮件导入检验工具类
 * @Date 2019/4/17 0017 上午 10:57
 * @Created by Pengrenjun
 */
@Service
public class EmailRemindService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private  PmsEmailOidPoMapper pmsEmailOidPoMapper;

    @Autowired
    private  UecPmsMailMapper uecPmsMailMapper;

    @Autowired
    private  PssEmailPoMapper pssEmailPoMapper;



    private static BigDecimal oid;


    /**
     * 校验流程ID在UEC_PMS_EMAIL_OID中是否存在
     * @param basicConfigParam
     * @param roseEamilThemeTemplate
     * @return oid
     */
    @Transactional
    public  void importRoseEmail(List<? extends BasicConfigParam> basicConfigParams, RoseEamilThemeTemplate roseEamilThemeTemplate) throws ParseException {

        for(BasicConfigParam basicConfigParam:basicConfigParams){
            //校验流程ID在UEC_PMS_EMAIL_OID中是否存在
            PmsEmailOidPoExample pmsEmailOidPoExample=new PmsEmailOidPoExample();
            pmsEmailOidPoExample.createCriteria().andProcessInstanceIdEqualTo(basicConfigParam.getProcess_instance_id());
            List<PmsEmailOidPo> pmsEmailOidPoList = pmsEmailOidPoMapper.selectByExample(pmsEmailOidPoExample);

            //如果流程ID在UEC_PMS_EMAIL_OID中不存在,则在UEC_PMS_EMAIL_OID中新生成一条数据
            if(CollectionUtils.isEmpty(pmsEmailOidPoList)){
                //向UEC_PMS_EMAIL_OID表中插入一条新的数据
                oid=insertPmsEmailOidPoToUecPmsEmail(basicConfigParam.getProcess_instance_id());
            }
            else {
                oid=pmsEmailOidPoList.get(0).getOid();
            }

            importEmailMessage(basicConfigParam,oid,roseEamilThemeTemplate);
        }
        logger.info("{}->  邮件信息导入完毕》》》》》》",roseEamilThemeTemplate.name());
    }

    /**
     * 向UEC_PMS_EMAIL_OID表中插入一条新的数据
     * @return oid
     */
    private  BigDecimal insertPmsEmailOidPoToUecPmsEmail(String processInstanceId) {
        PmsEmailOidPo pmsEmailOidPo=new PmsEmailOidPo();
        pmsEmailOidPo.setProcessInstanceId(processInstanceId);
        pmsEmailOidPo.setOid(BigDecimal.valueOf(uecPmsMailMapper.getOidNextSeq()));
        pmsEmailOidPoMapper.insertSelective(pmsEmailOidPo);
        return  pmsEmailOidPo.getOid();
    }

    /**
     * 向 UEC_PSS_EMAIL 表中中导入邮件数据
     * @param emailparams
     * @param oid
     * @param roseEamilThemeTemplate
     */
    public  void importEmailMessage(BasicConfigParam emailparam,BigDecimal oid, RoseEamilThemeTemplate roseEamilThemeTemplate) throws ParseException {
        //邮件主题内容
        String themeMessage="";
        //邮件内容
        String contentMessage="";
        //邮件地址
        String emailAddr="";

        //流程名称
        String process_instance_name = emailparam.getProcess_instance_name();
        //提交人姓名
        String submitter_name = emailparam.getSubmitter_name();

        themeMessage=MessageFormat.format(roseEamilThemeTemplate.themeMessage,process_instance_name,submitter_name);

        if(roseEamilThemeTemplate==RoseEamilThemeTemplate.Todo){

            TodoRemindConfig todoRemindConfig=(TodoRemindConfig)emailparam;
            emailAddr=todoRemindConfig.getHandler_email();
            contentMessage=MessageFormat.format(RoseEamilContentTemplate.Todo.contentMessage,submitter_name,todoRemindConfig.getSubmitter_no(),process_instance_name);
        }

        if(roseEamilThemeTemplate==RoseEamilThemeTemplate.Approved){
            FinishApprRemindConfig finishApprRemindConfig=(FinishApprRemindConfig)emailparam;
            emailAddr=finishApprRemindConfig.getSubmitter_email();
            contentMessage=MessageFormat.format(RoseEamilContentTemplate.Approved.contentMessage,process_instance_name);
        }

        if(roseEamilThemeTemplate==RoseEamilThemeTemplate.RejectToSubmit){
            RejectToSubmitRemindConfig rejectToSubmitRemindConfig=(RejectToSubmitRemindConfig)emailparam;
            emailAddr=rejectToSubmitRemindConfig.getSubmitter_email();
            contentMessage=MessageFormat.format(RoseEamilContentTemplate.RejectToSubmit.contentMessage,process_instance_name,rejectToSubmitRemindConfig.getReject_reason());
        }

        if(roseEamilThemeTemplate==RoseEamilThemeTemplate.RejectToApprove){
            RejectToApprRemindConfig rejectToApprRemindConfig=(RejectToApprRemindConfig)emailparam;
            emailAddr=rejectToApprRemindConfig.getApprover_email();
            contentMessage=MessageFormat.format(RoseEamilContentTemplate.RejectToApprove.contentMessage,submitter_name,rejectToApprRemindConfig.getSubmitter_no(),process_instance_name,rejectToApprRemindConfig.getReject_reason());
        }

        //校验邮件地址 主题 内容是否在UEC_PSS_EMAIL表中存在
        Boolean mailIsExsit = checkMailIsExsit(emailAddr, themeMessage, contentMessage);
        if(mailIsExsit){
            logger.info("{} 在UEC_PSS_EMAIL表中已存在!!", JSONObject.toJSONString(emailparam));
            return;
        }

        //向UEC_PSS_EMAIL表中插入邮件信息
        insertPmsmailPo( emailAddr, SimpleDateFormat.getDateTimeInstance().parse(emailparam.getUpdate_time()), themeMessage,  contentMessage, oid);
        logger.info("{} 已存入UEC_PSS_EMAIL表中>>", JSONObject.toJSONString(emailparam));
    }




    /**
     * 校验邮件地址 主题 内容是否在UEC_PSS_EMAIL表中存在
     * @param emailAddr
     * @param themeMessage
     * @param contentMessage
     */
    private  Boolean checkMailIsExsit(String emailAddr, String themeMessage, String contentMessage) {

        PssEmailPo pssEmailPo =new PssEmailPo();
        PssEmailPoExample pssEmailPoExample=new PssEmailPoExample();
        pssEmailPoExample.createCriteria().andMailtoEqualTo(emailAddr).andMtitleEqualTo(themeMessage).andMtextEqualTo(contentMessage);
        List<PssEmailPo> pssEmailPos = pssEmailPoMapper.selectByExample(pssEmailPoExample);

        if(CollectionUtils.isEmpty(pssEmailPos)){
            return  false;
        }
        return true;
    }

    /**
     * 向 UEC_PSS_EMAIL 表中插入邮件信息
     * @param emailAddr
     * @param update_time
     * @param themeMessage
     * @param contentMessage
     * @param oid
     */
    private  void insertPmsmailPo(String emailAddr, Date update_time, String themeMessage, String contentMessage, BigDecimal oid) {
        PssEmailPo pssEmailPo =new PssEmailPo();
        pssEmailPo.setCreationtime(update_time);
        pssEmailPo.setMoid(oid);
        pssEmailPo.setMailto(emailAddr);
        pssEmailPo.setMtitle(themeMessage);
        pssEmailPo.setMtext(contentMessage);
        pssEmailPoMapper.insertSelective(pssEmailPo);
    }


    /**
     * 邮件主题模板
     */
    public static enum RoseEamilThemeTemplate{
        Todo("【{0}-{1}】,请您审批"),
        Approved("【{0}-{1}】审批完成通知"),
        RejectToSubmit("【{0}-{1}】驳回通知"),
        RejectToApprove("【{0}-{1}】驳回通知");
        private String themeMessage;
        RoseEamilThemeTemplate(String themeMessage) {
            this.themeMessage = themeMessage;
        }
    }

    /**
     * 邮件内容模板
     */
    public static enum RoseEamilContentTemplate{
        Todo("<br>您好！<br><br>员工{0} {1}已经提交了{2}，请您注意审批。<br><br>Rose系统访问地址(请使用谷歌、火狐浏览器)：<a href=http://roseweboprtest.it.ronglian.com/?tdsourcetag=s_pcqq_aiomsg#/manualLogin target=_blank>Rose系统</a>"),
        Approved("<br>您好！<br><br>您的{0}流程已经审批通过。<br><br>Rose系统访问地址(请使用谷歌、火狐浏览器)：<a href=http://roseweboprtest.it.ronglian.com/?tdsourcetag=s_pcqq_aiomsg#/manualLogin target=_blank>Rose系统</a>"),
        RejectToSubmit("<br>您好！<br><br>您的{0}流程已经被驳回，原因：{1}。<br><br>Rose系统访问地址(请使用谷歌、火狐浏览器)：<a href=http://roseweboprtest.it.ronglian.com/?tdsourcetag=s_pcqq_aiomsg#/manualLogin target=_blank>Rose系统</a>"),
        RejectToApprove("<br>您好！<br><br>员工{0}({1})的{2}流程已经被驳回，原因：{3}。<br><br>Rose系统访问地址(请使用谷歌、火狐浏览器)：<a href=http://roseweboprtest.it.ronglian.com/?tdsourcetag=s_pcqq_aiomsg#/manualLogin target=_blank>Rose系统</a>");
        private String contentMessage;
        RoseEamilContentTemplate(String contentMessage) {
            this.contentMessage = contentMessage;
        }
    }


}
