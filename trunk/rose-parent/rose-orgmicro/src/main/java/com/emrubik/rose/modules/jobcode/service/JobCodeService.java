package com.emrubik.rose.modules.jobcode.service;

import com.emrubik.entity.common.QueryReq;
import com.emrubik.entity.common.QueryResp;
import com.emrubik.entity.dept.DeptInfo;
import com.emrubik.entity.jobcode.JobCodeInfo;
import com.emrubik.rose.config.RestTemplateUrlConfig;
import com.emrubik.rose.generator.dao.JobCodePoMapper;
import com.emrubik.rose.generator.dao.bean.DeptPo;
import com.emrubik.rose.generator.dao.bean.DeptPoExample;
import com.emrubik.rose.generator.dao.bean.JobCodePo;
import com.emrubik.rose.generator.dao.bean.JobCodePoExample;
import com.emrubik.rose.scheduler.job.DeptImportTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: sunyingji
 * @create: 2019-03-20 15:29
 **/
@Service
public class JobCodeService {

    //日志打印
    Logger logger= LoggerFactory.getLogger(JobCodeService.class);

    @Autowired
    private JobCodePoMapper jobCodePoMapper;

    @Autowired
    private RestTemplateUrlConfig restTemplateUrlConfig;

    @Autowired
    private RestTemplate restTemplate;

    public QueryResp importJobCodeInfoToRose(){

        //查询出所有职务数据
        JobCodePoExample jobCodePoExample=new JobCodePoExample();
        jobCodePoExample.createCriteria().andOidIsNotNull().andStatusEqualTo("A").andJobcodeIsNotNull();

        List<JobCodePo> jobCodePos = jobCodePoMapper.selectByExample(jobCodePoExample);

        //对职务数据进行处理
        List<JobCodeInfo> result = jobCodePos.stream().map((jobCode) -> {
            //这里需要进一步处理
            JobCodeInfo jobCodeInfo=new JobCodeInfo();
            jobCodeInfo.setPosition_id(jobCode.getJobcode());
            jobCodeInfo.setPosition_name(jobCode.getDescr());
            if ("A".equals(jobCode.getEffdtStatus())){
                jobCodeInfo.setPosition_status("1");
            }else if("I".equals(jobCode.getEffdtStatus())){
                jobCodeInfo.setPosition_status("0");
            }
            return jobCodeInfo;
        }).collect(Collectors.toList());

        QueryReq<JobCodeInfo> queryReq=new QueryReq<>();
        queryReq.setHandle_type(0);
        queryReq.setData(result);

        String importUrl = restTemplateUrlConfig.getJobCodeImportUrl();

        QueryResp queryResp = restTemplate.postForObject(importUrl, queryReq, QueryResp.class);

        return  queryResp;

    }
}
