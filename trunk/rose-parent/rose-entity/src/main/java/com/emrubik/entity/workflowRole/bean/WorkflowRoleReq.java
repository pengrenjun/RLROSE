package com.emrubik.entity.workflowRole.bean;

import java.util.List;

/**
 * @Description 远程调用Rose审批流程角色导入接口 请求参数
 * @Date 2019/3/20 0020 下午 4:00
 * @Created by Pengrenjun
 */
public class WorkflowRoleReq {

    //流程审批组编号
    private String workflowCode;
    //人员id集合
    private List<String> empIds;

    public String getWorkflowCode() {
        return workflowCode;
    }

    public void setWorkflowCode(String workflowCode) {
        this.workflowCode = workflowCode;
    }

    public List<String> getEmpIds() {
        return empIds;
    }

    public void setEmpIds(List<String> empIds) {
        this.empIds = empIds;
    }
}
