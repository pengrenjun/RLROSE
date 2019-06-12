package com.emrubik.rose.scheduler.job;

import com.emrubik.entity.common.QueryResp;
import com.emrubik.rose.Utils.DateTimeUtils;
import com.emrubik.rose.modules.dept.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description:组织机构导入定时任务
 * @author: sunyingji
 * @create: 2019-03-19 13:56
 **/
@Component
public class DeptImportTask {

    //日志打印
    Logger logger= LoggerFactory.getLogger(DeptImportTask.class);

    @Autowired
    private DeptService deptService;





    @Scheduled(cron ="0 0/5 * * * *")
    public void deptImportTask(){
        logger.info("{}  调用Rose远程部门数据批量导入接口 定时任务准备执行>>>>>>>>>>>>", DateTimeUtils.currentDateTostr());
        QueryResp queryResp= deptService.importDeptInfoToRose();
        //执行定时任务
        if(queryResp.getResult()){
            logger.info("{} Rose远程部门数据批量导入定时任务执行完毕 ！",DateTimeUtils.currentDateTostr());
        }
        else {
            logger.info("{} Rose远程部门数据批量导入定时任务执行出现异常 ! 异常信息：{}",DateTimeUtils.currentDateTostr(),queryResp.getMsg());
        }
    }
}

