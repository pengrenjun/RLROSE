package com.emrubik.entity.common;

import org.assertj.core.util.Lists;

import javax.validation.Valid;
import java.util.List;

/**
 * @description: 封装请求参数
 * @author: sunyingji
 * @create: 2019-03-20 09:52
 **/
public class QueryReq<T> {

    private Integer handle_type;

    @Valid
    private List<T> data= Lists.newArrayList();


    public Integer getHandle_type() {
        return handle_type;
    }

    public void setHandle_type(Integer handle_type) {
        this.handle_type = handle_type;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }


}
