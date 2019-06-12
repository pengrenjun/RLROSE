package com.emrubik.entity.employee.bean;

/**
 * @Description 调用Rose远程人员数据导入接口 部门信息传参对象(依据接口文档定义的传参Bean)
 * @Date 2019/3/21 0021 下午 1:58
 * @Created by Pengrenjun
 */
public class OrgInfo {
    //部门编码
    private  String org_code;
    //部门名称
    private  String org_name;
    //职位名称id
    private  String emp_position_id;
    //是否为主部门 ：Y 是
    private  String is_first_org;
    //直接上级编码
    private  String up_emp_id;

    public String getOrg_code() {
        return org_code;
    }

    public void setOrg_code(String org_code) {
        this.org_code = org_code;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getEmp_position_id() {
        return emp_position_id;
    }

    public void setEmp_position_id(String emp_position_id) {
        this.emp_position_id = emp_position_id;
    }

    public String getIs_first_org() {
        return is_first_org;
    }

    public void setIs_first_org(String is_first_org) {
        this.is_first_org = is_first_org;
    }

    public String getUp_emp_id() {
        return up_emp_id;
    }

    public void setUp_emp_id(String up_emp_id) {
        this.up_emp_id = up_emp_id;
    }
}
