package com.emrubik.entity.email;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;

/**
 * @description: 审批完成提醒参数配置
 * @author: sunyingji
 * @create: 2019-04-16 17:35
 **/
public class FinishApprRemindConfig extends BasicConfigParam {

    //提交人邮件地址
    @Valid
    @NotEmpty(message = "邮件地址不能为空！")
    private String  submitter_email;

    public String getSubmitter_email() {
        return submitter_email;
    }

    public void setSubmitter_email(String submitter_email) {
        this.submitter_email = submitter_email;
    }
}
