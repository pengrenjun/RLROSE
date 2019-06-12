package com.emrubik.rose.modules.workflowRole.service;

import com.emrubik.entity.common.QueryReq;
import com.emrubik.entity.common.QueryResp;
import com.emrubik.entity.employee.bean.EmployeeEntity;
import com.emrubik.entity.workflowRole.bean.WorkflowRoleReq;
import com.emrubik.rose.config.RestTemplateUrlConfig;
import com.emrubik.rose.generator.dao.EmplyeePoMapper;
import com.emrubik.rose.generator.dao.RoseWorkflowPoMapper;
import com.emrubik.rose.generator.dao.bean.EmplyeePo;
import com.emrubik.rose.generator.dao.bean.EmplyeePoExample;
import com.emrubik.rose.generator.dao.bean.RoseWorkflowPo;
import com.emrubik.rose.generator.dao.bean.RoseWorkflowPoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description 流程审批角色导入Rose定时service
 * @Date 2019/3/20 0020 上午 11:28
 * @Created by Pengrenjun
 */

@Service
public class WorkFlowRoleService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RoseWorkflowPoMapper  roseWorkflowPoMapper;

    @Autowired
    private RestTemplateUrlConfig restTemplateUrlConfig;

    //远程调用接口传参参数
    private static QueryReq<WorkflowRoleReq> roseWorkflowPoQueryReq=new QueryReq();
    //审批流程角色数据组装
    private static WorkflowRoleReq workflowRoleReq=new WorkflowRoleReq();
    //传入roseWorkflowPoQueryReq的list参数
    private static List<WorkflowRoleReq> workflowRoleReqList=new ArrayList<>();
    //rose远程导入审批流程接口地址
    private String url;
    //远程接口调用响应结果
    private QueryResp queryResp=new QueryResp();


    /**
     * 定时导入方法
     * @return QueryResp
     */
    public QueryResp importWorkflowRolesToRose(){

        try {
            List<RoseWorkflowPo> roseWorkflowPoList=getAllWorkflowRoles();

            Assert.notNull(roseWorkflowPoList,"审批流程角色数据查询为空，不执行定时审批流程数据导入任务!");

            url=restTemplateUrlConfig.getWorkflowRoleImportUrl();

            //处理查询出的所有流程审批角色数据,使其符合Rose接口要求的数据格式——>每个流程审批组编号对应一组人员ID
            // {handle_type:"",data:[{"workflowCode":"R201903130095","empIds":[“01234”,”04321”]},{"workflowCode":"R201903130096","empIds":[“01235”,”04322”]}]}
            //数据分组
            Map<String, List<RoseWorkflowPo>> groupBySex = roseWorkflowPoList.stream()
                                                           .collect(Collectors.groupingBy(RoseWorkflowPo::getWorkflowcode));
            for(Map.Entry entry:groupBySex.entrySet()){

                //组装接口发送数据
                List<RoseWorkflowPo> roseWorkflowPos= (List<RoseWorkflowPo>) entry.getValue();

                //获取list对象的某个字段组装成新list
                List<String > empIdsList =  roseWorkflowPos.stream().map(a -> a.getEmpid()).collect(Collectors.toList());

                workflowRoleReq.setWorkflowCode((String)entry.getKey());
                workflowRoleReq.setEmpIds(empIdsList);

                workflowRoleReqList.clear();
                workflowRoleReqList.add(workflowRoleReq);
            }
            //设置传参数据
            roseWorkflowPoQueryReq.setHandle_type(0);
            roseWorkflowPoQueryReq.setData( workflowRoleReqList);
            //调用Rose远程服务接口
            queryResp = restTemplate.postForObject(url,roseWorkflowPoQueryReq, QueryResp.class);
        } catch (Exception e) {
            queryResp.setResult(false);
            queryResp.setMsg(e.getMessage());
        }
        //返回Rose接口调用结果
        return  queryResp;
    }



    /**
     * 获取所有的审批角色数据
     * @return List<RoseWorkflowPo>
     */
    public List<RoseWorkflowPo> getAllWorkflowRoles(){
        RoseWorkflowPoExample roseWorkflowPoExample=new RoseWorkflowPoExample();
        RoseWorkflowPoExample.Criteria criteria = roseWorkflowPoExample.createCriteria();
        criteria.andWorkflowcodeIsNotNull();
        List<RoseWorkflowPo> roseWorkflowPoList = roseWorkflowPoMapper.selectByExample(roseWorkflowPoExample);
        return  roseWorkflowPoList;
    }

}
