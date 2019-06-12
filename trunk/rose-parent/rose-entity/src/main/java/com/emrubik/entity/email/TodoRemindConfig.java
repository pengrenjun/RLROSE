package com.emrubik.entity.email;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * @description: 待办提醒参数设置
 * @author: sunyingji
 * @create: 2019-04-16 17:32
 **/

public class TodoRemindConfig extends BasicConfigParam  {

    //提交人工号
    @NotEmpty(message = "提交人工号不能为空！")
    private String submitter_no;

    //待办人邮件地址
    @NotEmpty(message = "邮件地址不能为空！")
    private String handler_email;


    public String getSubmitter_no() {
        return submitter_no;
    }

    public void setSubmitter_no(String submitter_no) {
        this.submitter_no = submitter_no;
    }

    public String getHandler_email() {
        return handler_email;
    }

    public void setHandler_email(String handler_email) {
        this.handler_email = handler_email;
    }
}
