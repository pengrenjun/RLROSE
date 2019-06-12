package com.emrubik.entity.common;

/**
 * @description: 远程调用响应
 * @author: sunyingji
 * @create: 2019-03-20 09:56
 **/
public class QueryResp {

  private Boolean result;

  private String msg;


    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
