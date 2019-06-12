package com.emrubik.rose.modules.employee.controller;

import com.alibaba.fastjson.JSONObject;
import com.emrubik.entity.common.QueryReq;
import com.emrubik.entity.common.QueryResp;
import com.emrubik.entity.email.RejectToApprRemindConfig;
import com.emrubik.entity.employee.bean.EmployeeEntity;
import com.emrubik.rose.generator.dao.EmplyeePoMapper;
import com.emrubik.rose.generator.dao.bean.EmplyeePo;
import com.emrubik.rose.generator.dao.bean.EmplyeePoExample;
import com.emrubik.rose.generator.dao.bean.RoseWorkflowPo;
import com.emrubik.rose.generator.dao.bean.RoseWorkflowPoExample;
import com.emrubik.rose.modules.employee.mapper.EmployEntitiyMapper;
import org.apache.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description PS人员数据对外提供接口
 * @Date 2019/4/17 0017 上午 10:23
 * @Created by Pengrenjun
 */
@RestController
public class PushEmployeeDateController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmplyeePoMapper emplyeePoMapper;

    /**
     * 获取PS系统的人员数据 用于第三方系统使用
     * @return json数据格式
     */
    @GetMapping("/pssoft/getPsAllEmployeeDate")
    public String getPsAllEmployeeDate(){

         logger.info("第三方系统准备获取peoplesoft里面的人员数据信息,返回json数据!");

         EmplyeePoExample emplyeePoExample=new EmplyeePoExample();
         EmplyeePoExample.Criteria criteria = emplyeePoExample.createCriteria();
         //查询有效非虚拟的用户
         criteria.andEffdtStatusEqualTo("A").andStaffNoNotLike("XN%");
         List<EmplyeePo> emplyeePoList = emplyeePoMapper.selectByExample(emplyeePoExample);

         logger.info("获取人员数据 共："+emplyeePoList.size());

         String jsonDate=JSONObject.toJSONString(emplyeePoList);

         return jsonDate;
    }


}
