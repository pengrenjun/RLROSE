package com.emrubik.entity.employee.bean;

import java.util.List;

/**
 * @Description 调用Rose远程人员数据导入接口传参对象(依据接口文档定义的传参Bean)
 * @Date 2019/3/21 0021 上午 11:12
 * @Created by Pengrenjun
 */
public class EmployeeEntity {

    //工号
    private String  emp_id ;
    //姓名
    private String  emp_name ;
    //性别(M男,F女)
    private String  emp_sex ;
    //固定电话
    private String  emp_phone;
    //手机号
    private String  emp_mobile_phone;
    //传真
    private String  emp_fax;
    //邮箱
    private String  emp_email;
    //密码
    private String  emp_password;
    //生日 年-月-日 时:分:秒
    private String  emp_birthday;
    //联系地址(住址)
    private String  emp_address;
    //工作地址
    private String  emp_work_address;
    //个性说明
    private String  emp_message;
    //入职时间 20190313162323  (14位字符串)
    private String  entry_time;
    //证件类型(0身份证,1户口簿,2护照,3军官证,4港澳通行证)
    private String  cer_type;
    //证件号码
    private String  cer_no;
    //在职状态(0:离职,1:在职)
    private String  emp_active;
    //账号状态 0禁用1启用
    private String  emp_enabled;

    private List<OrgInfo>  emp_org;

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_sex() {
        return emp_sex;
    }

    public void setEmp_sex(String emp_sex) {
        this.emp_sex = emp_sex;
    }

    public String getEmp_phone() {
        return emp_phone;
    }

    public void setEmp_phone(String emp_phone) {
        this.emp_phone = emp_phone;
    }

    public String getEmp_mobile_phone() {
        return emp_mobile_phone;
    }

    public void setEmp_mobile_phone(String emp_mobile_phone) {
        this.emp_mobile_phone = emp_mobile_phone;
    }

    public String getEmp_fax() {
        return emp_fax;
    }

    public void setEmp_fax(String emp_fax) {
        this.emp_fax = emp_fax;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public String getEmp_password() {
        return emp_password;
    }

    public void setEmp_password(String emp_password) {
        this.emp_password = emp_password;
    }

    public String getEmp_birthday() {
        return emp_birthday;
    }

    public void setEmp_birthday(String emp_birthday) {
        this.emp_birthday = emp_birthday;
    }

    public String getEmp_address() {
        return emp_address;
    }

    public void setEmp_address(String emp_address) {
        this.emp_address = emp_address;
    }

    public String getEmp_work_address() {
        return emp_work_address;
    }

    public void setEmp_work_address(String emp_work_address) {
        this.emp_work_address = emp_work_address;
    }

    public String getEmp_message() {
        return emp_message;
    }

    public void setEmp_message(String emp_message) {
        this.emp_message = emp_message;
    }

    public String getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(String entry_time) {
        this.entry_time = entry_time;
    }

    public String getCer_type() {
        return cer_type;
    }

    public void setCer_type(String cer_type) {
        this.cer_type = cer_type;
    }

    public String getCer_no() {
        return cer_no;
    }

    public void setCer_no(String cer_no) {
        this.cer_no = cer_no;
    }

    public String getEmp_active() {
        return emp_active;
    }

    public void setEmp_active(String emp_active) {
        this.emp_active = emp_active;
    }

    public String getEmp_enabled() {
        return emp_enabled;
    }

    public void setEmp_enabled(String emp_enabled) {
        this.emp_enabled = emp_enabled;
    }

    public List<OrgInfo> getEmp_org() {
        return emp_org;
    }

    public void setEmp_org(List<OrgInfo> emp_org) {
        this.emp_org = emp_org;
    }
}



