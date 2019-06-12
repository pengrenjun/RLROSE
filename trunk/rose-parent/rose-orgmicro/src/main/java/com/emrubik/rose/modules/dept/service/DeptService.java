package com.emrubik.rose.modules.dept.service;

import com.emrubik.entity.common.QueryReq;
import com.emrubik.entity.common.QueryResp;
import com.emrubik.entity.dept.DeptInfo;
import com.emrubik.rose.config.RestTemplateUrlConfig;
import com.emrubik.rose.generator.dao.DeptPoMapper;
import com.emrubik.rose.generator.dao.bean.DeptPo;
import com.emrubik.rose.generator.dao.bean.DeptPoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:部门导入服务
 * @author: sunyingji
 * @create: 2019-03-19 13:45
 **/
@Service
public class DeptService {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DeptPoMapper deptPoMapper;

    @Autowired
    private RestTemplateUrlConfig restTemplateUrlConfig;

    /**
     * second(秒) ,minute(分), hour(时), day of month(日), month (月),day of week(周几).
     *
     * */
    //@Scheduled(cron ="0 * * * * MON-FRI")
    //@Scheduled(cron ="0,1,2,3,4 * * * * MON-FRI") 枚举
    //@Scheduled(cron ="0-4 * * * * MON-FRI")区间
    //@Scheduled(cron ="0/4 * * * * MON-FRI")步长 每4秒启动一次
    // @Scheduled(cron = "0 0 2 * * ?")？用于日和星期的冲突匹配
    public void hello(){
        System.out.println("hello.....");
    }


    public QueryResp importDeptInfoToRose(){
        //查询出所有部门数据
        DeptPoExample deptPoExample=new DeptPoExample();
        deptPoExample.createCriteria().andOidIsNotNull().andStatusEqualTo("A").andDeptidIsNotNull().andEffdtStatusEqualTo("A");
        List<DeptPo> deptPos = deptPoMapper.selectByExample(deptPoExample);

        //对部门数据进行处理
        List<DeptInfo> result = deptPos.stream().map((dept) -> {
            DeptInfo deptInfo=new DeptInfo();
            deptInfo.setOrg_name(dept.getDeptName());
            deptInfo.setOrg_code(dept.getDeptid());
            deptInfo.setOrg_leave(dept.getuDeptLevel());
            deptInfo.setParent_org_code(dept.getUpDeptid());
            deptInfo.setSec_order(null);
            deptInfo.setOrg_name_all(dept.getDeptAllname());
            if("A".equals(dept.getEffdtStatus())){
                deptInfo.setSec_enabled("1");
            }else if("I".equals(dept.getEffdtStatus())){
                deptInfo.setSec_enabled("0");
            }

            deptInfo.setManage_emp_id(dept.getManagerId());
            deptInfo.setManage_emp_name(dept.getManagerName());
            deptInfo.setCharge_emp_id(null);
            deptInfo.setCharge_emp_name(null);
            //这里需要进一步处理
            return deptInfo;
        }).collect(Collectors.toList());

        QueryReq<DeptInfo> queryReq=new QueryReq<>();
        queryReq.setHandle_type(0);
        queryReq.setData(result);

        String importUrl = restTemplateUrlConfig.getDeptImportUrl();

        QueryResp queryResp = restTemplate.postForObject(importUrl, queryReq, QueryResp.class);

        return  queryResp;
    }

}
