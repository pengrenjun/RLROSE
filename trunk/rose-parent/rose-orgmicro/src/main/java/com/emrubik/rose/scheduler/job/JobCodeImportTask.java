package com.emrubik.rose.scheduler.job;

import com.emrubik.entity.common.QueryResp;
import com.emrubik.rose.Utils.DateTimeUtils;
import com.emrubik.rose.modules.dept.service.DeptService;
import com.emrubik.rose.modules.jobcode.service.JobCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description: 职务数据导入定时任务
 * @author: sunyingji
 * @create: 2019-03-20 15:28
 **/
@Component
public class JobCodeImportTask {

    //日志打印
    Logger logger= LoggerFactory.getLogger(DeptImportTask.class);


    @Autowired
    private JobCodeService jobCodeService;


    @Scheduled(cron ="0 0/5 * * * *")
    public void jobCodeImportTask(){
        logger.info("{}  调用Rose远程职务数据批量导入接口 定时任务准备执行>>>>>>>>>>>>", DateTimeUtils.currentDateTostr());
        QueryResp queryResp= jobCodeService.importJobCodeInfoToRose();
        //执行定时任务
        if(queryResp.getResult()){
            logger.info("{} Rose远程职务数据批量导入定时任务执行完毕 ！",DateTimeUtils.currentDateTostr());
        }
        else {
            logger.info("{} Rose远程职务数据批量导入定时任务执行出现异常 ! 异常信息：{}",DateTimeUtils.currentDateTostr(),queryResp.getMsg());
        }
    }
}
