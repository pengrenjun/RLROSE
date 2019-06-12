package com.emrubik.rose.scheduler.job;

import com.emrubik.entity.common.QueryResp;
import com.emrubik.entity.employee.bean.EmployeeEntity;
import com.emrubik.rose.Utils.DateTimeUtils;
import com.emrubik.rose.modules.employee.service.EmployeeService;
import com.emrubik.rose.modules.workflowRole.service.WorkFlowRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description 审批流程角色导入Rose定时任务
 * @Date 2019/3/20 0020 上午 11:45
 * @Created by Pengrenjun
 */
@Component
public class WorkFlowRolesImportTask {

    //日志打印
    Logger logger= LoggerFactory.getLogger(WorkFlowRolesImportTask.class);

    @Autowired
    private WorkFlowRoleService workFlowRoleService;


    /*@Scheduled(cron ="0 0/5 * * * *")*/
    public void workFlowRolesImportTask(){

        logger.info("{}  调用Rose远程审批流程批量导入接口 定时任务准备执行>>>>>>>>>>>>",DateTimeUtils.currentDateTostr());
        //执行定时任务
        QueryResp queryResp=workFlowRoleService.importWorkflowRolesToRose();
        if(queryResp.getResult()){
            logger.info("{} Rose远程审批流程角色数据批量导入定时任务执行完毕 ！",DateTimeUtils.currentDateTostr());
        }
        else {
            logger.error("{} Rose远程审批流程角色数据批量导入定时任务执行出现异常 ! 异常信息：{}",DateTimeUtils.currentDateTostr(),queryResp.getMsg());
        }

    }
}
