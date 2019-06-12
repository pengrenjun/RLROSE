package com.emrubik.entity.dept;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @description: 部门信息
 * @author: sunyingji
 * @create: 2019-03-20 11:20
 **/
public class DeptInfo implements Serializable {

    //部门名称
    private String org_name;
    //部门编码
    private String org_code;
    //部门层级
    private String org_leave;
    //上级部门编码
    private String parent_org_code;
    //部门显示顺序
    private String sec_order;
    //部门是否可用(0禁用1正常)
    private String sec_enabled;
    // 主管领导工号
    private String manage_emp_id;
    //主管领导名字
    private String manage_emp_name;
    //分管领导ID
    private String charge_emp_id;
    //分管领导名字
    private String charge_emp_name;

    //部门全称
    private  String org_name_all;

    public String getOrg_name_all() {
        return org_name_all;
    }

    public void setOrg_name_all(String org_name_all) {
        this.org_name_all = org_name_all;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }


    public String getOrg_code() {
        return org_code;
    }

    public void setOrg_code(String org_code) {
        this.org_code = org_code;
    }

    public String getOrg_leave() {
        return org_leave;
    }

    public void setOrg_leave(String org_leave) {
        this.org_leave = org_leave;
    }

    public String getParent_org_code() {
        return parent_org_code;
    }

    public void setParent_org_code(String parent_org_code) {
        this.parent_org_code = parent_org_code;
    }

    public String getSec_order() {
        return sec_order;
    }

    public void setSec_order(String sec_order) {
        this.sec_order = sec_order;
    }

    public String getSec_enabled() {
        return sec_enabled;
    }

    public void setSec_enabled(String sec_enabled) {
        this.sec_enabled = sec_enabled;
    }

    public String getManage_emp_id() {
        return manage_emp_id;
    }

    public void setManage_emp_id(String manage_emp_id) {
        this.manage_emp_id = manage_emp_id;
    }

    public String getManage_emp_name() {
        return manage_emp_name;
    }

    public void setManage_emp_name(String manage_emp_name) {
        this.manage_emp_name = manage_emp_name;
    }

    public String getCharge_emp_id() {
        return charge_emp_id;
    }

    public void setCharge_emp_id(String charge_emp_id) {
        this.charge_emp_id = charge_emp_id;
    }

    public String getCharge_emp_name() {
        return charge_emp_name;
    }

    public void setCharge_emp_name(String charge_emp_name) {
        this.charge_emp_name = charge_emp_name;
    }
}
