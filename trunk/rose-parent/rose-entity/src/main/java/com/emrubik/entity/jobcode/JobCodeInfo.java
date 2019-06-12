package com.emrubik.entity.jobcode;

/**
 * @description:
 * @author: sunyingji
 * @create: 2019-03-20 15:48
 **/
public class JobCodeInfo {

     //职务ID,
     private String position_id;
     //职务名称
     private String position_name;
      //0禁用 1正常
     private String position_status;


    public String getPosition_id() {
        return position_id;
    }

    public void setPosition_id(String position_id) {
        this.position_id = position_id;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public String getPosition_status() {
        return position_status;
    }

    public void setPosition_status(String position_status) {
        this.position_status = position_status;
    }
}
