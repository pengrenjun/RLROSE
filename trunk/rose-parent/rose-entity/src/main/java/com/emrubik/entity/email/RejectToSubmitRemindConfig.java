package com.emrubik.entity.email;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @description: 驳回提醒--提交人
 * @author: sunyingji
 * @create: 2019-04-16 17:37
 **/
public class RejectToSubmitRemindConfig extends BasicConfigParam {

    //提交人邮件地址
    @NotEmpty(message = "邮件地址不能为空！")
    private String submitter_email;

    //驳回原因
    private String reject_reason;

    public String getSubmitter_email() {
        return submitter_email;
    }

    public void setSubmitter_email(String submitter_email) {
        this.submitter_email = submitter_email;
    }

    public String getReject_reason() {
        return reject_reason;
    }

    public void setReject_reason(String reject_reason) {
        this.reject_reason = reject_reason;
    }
}
