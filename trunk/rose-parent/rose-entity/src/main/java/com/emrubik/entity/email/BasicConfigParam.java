package com.emrubik.entity.email;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.util.Date;

/**
 * @description: 基础设置参数，其他的配置继承这个配置
 * @author: sunyingji
 * @create: 2019-04-16 16:47
 **/
public class BasicConfigParam  {
    @Valid
    @NotEmpty(message = "流程实例id不能为空！")
    private String process_instance_id;

    @Valid
    @NotEmpty(message = "流程实例名称不能为空！")
    private String process_instance_name;

    @Valid
    @NotEmpty(message = "提交人姓名不能为空！")
    private String submitter_name;

    private String update_time;


    public String getProcess_instance_id() {
        return process_instance_id;
    }

    public void setProcess_instance_id(String process_instance_id) {
        this.process_instance_id = process_instance_id;
    }

    public String getProcess_instance_name() {
        return process_instance_name;
    }

    public void setProcess_instance_name(String process_instance_name) {
        this.process_instance_name = process_instance_name;
    }

    public String getSubmitter_name() {
        return submitter_name;
    }

    public void setSubmitter_name(String submitter_name) {
        this.submitter_name = submitter_name;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
