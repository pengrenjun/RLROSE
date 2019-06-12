package com.emrubik.rose.modules.employee.service;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.emrubik.entity.common.QueryReq;
import com.emrubik.entity.common.QueryResp;
import com.emrubik.entity.employee.bean.EmployeeEntity;
import com.emrubik.rose.config.RestTemplateUrlConfig;
import com.emrubik.rose.modules.employee.mapper.EmployEntitiyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Description 人员数据导入Rose定时Service
 * @Date 2019/3/20 0020 上午 9:41
 * @Created by Pengrenjun
 */

@Service
public class EmployeeService {

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private RestTemplateUrlConfig restTemplateUrlConfig;

    @Autowired
    private EmployEntitiyMapper employEntitiyMapper;

    //rose远程导入人员数据地址
    private  String url;
    //rose接口传参对象
    private QueryReq<EmployeeEntity> emplyeeQueryReq=new QueryReq();
    //rose接口调用信息响应
    private QueryResp queryResp= new QueryResp();

    private Logger logger= LoggerFactory.getLogger(EmployeeService.class);



    /**
     * 定时导入方法
     * @return QueryResp
     */
    public QueryResp importEmplyeesToRose(){

        try {
            List<EmployeeEntity> employeeEntityList=getAllEmplyees();

                Assert.notNull(employeeEntityList,"人员数据查询为空，不执行定时人员数据导入任务!");
                emplyeeQueryReq.setHandle_type(0);
                emplyeeQueryReq.setData(employeeEntityList);
                url=restTemplateUrlConfig.getEmplyeeImportUrl();
                //调用Rose远程服务接口
                queryResp = restTemplate.postForObject(url,emplyeeQueryReq, QueryResp.class);
        }
          catch (Exception e){
                queryResp.setResult(false);
                queryResp.setMsg(e.getMessage());
        }

        //返回Rose接口调用结果
        return queryResp;
    }



    /**
     * 获取所有的人员数据
     * @return List<EmployeeEntity>
     */
    public List<EmployeeEntity> getAllEmplyees(){

        List<EmployeeEntity> employeeEntityList = employEntitiyMapper.getAllEmployees();
        return  employeeEntityList;
    }
}




