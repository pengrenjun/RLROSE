package com.emrubik.entity.email;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @description: 驳回提醒--审批人
 * @author: sunyingji
 * @create: 2019-04-16 17:39
 **/
public class RejectToApprRemindConfig extends BasicConfigParam {
    //提交人工号
     @NotEmpty(message = "提交人工号不能为空！")
     private String submitter_no;
     //批准人邮件地
     @NotEmpty(message = "邮件地址不能为空！")
     private  String approver_email;
    //驳回原因
    @NotEmpty(message = "驳回原因不能为空！")
     private  String  reject_reason;

    public String getApprover_email() {
        return approver_email;
    }

    public void setApprover_email(String approver_email) {
        this.approver_email = approver_email;
    }

    public String getReject_reason() {
        return reject_reason;
    }

    public void setReject_reason(String reject_reason) {
        this.reject_reason = reject_reason;
    }

    public String getSubmitter_no() {
        return submitter_no;
    }

    public void setSubmitter_no(String submitter_no) {
        this.submitter_no = submitter_no;
    }
}
