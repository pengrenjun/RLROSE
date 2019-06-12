package com.emrubik.rose.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description Rose远程接口地址连接配置读取类
 * @Date 2019/3/20 0020 下午 1:41
 * @Created by Pengrenjun
 */

@Component
@PropertySource("classpath:/application.properties")
@ConfigurationProperties(prefix = "rose.import" )
public class RestTemplateUrlConfig {
    //部门数据导入
    private   String deptImportUrl;
    //职务数据导入
    private   String jobCodeImportUrl;
    //人员数据导入
    private   String emplyeeImportUrl;
    //审批流程角色导入
    private   String workflowRoleImportUrl;


    public String getDeptImportUrl() {
        return deptImportUrl;
    }

    public void setDeptImportUrl(String deptImportUrl) {
        this.deptImportUrl = deptImportUrl;
    }

    public String getJobCodeImportUrl() {
        return jobCodeImportUrl;
    }

    public void setJobCodeImportUrl(String jobCodeImportUrl) {
        this.jobCodeImportUrl = jobCodeImportUrl;
    }

    public String getEmplyeeImportUrl() {
        return emplyeeImportUrl;
    }

    public void setEmplyeeImportUrl(String emplyeeImportUrl) {
        this.emplyeeImportUrl = emplyeeImportUrl;
    }

    public String getWorkflowRoleImportUrl() {
        return workflowRoleImportUrl;
    }

    public void setWorkflowRoleImportUrl(String workflowRoleImportUrl) {
        this.workflowRoleImportUrl = workflowRoleImportUrl;
    }
}
