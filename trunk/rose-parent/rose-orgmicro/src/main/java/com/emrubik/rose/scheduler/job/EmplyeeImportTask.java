package com.emrubik.rose.scheduler.job;

import com.emrubik.entity.common.QueryResp;
import com.emrubik.rose.Utils.DateTimeUtils;
import com.emrubik.rose.modules.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * @Description 人员导入Rose定时任务
 * @Date 2019/3/20 0020 上午 10:34
 * @Created by Pengrenjun
 */

@Component
public class EmplyeeImportTask {

    //日志打印
    Logger logger= LoggerFactory.getLogger(EmplyeeImportTask.class);

    @Autowired
    private EmployeeService employeeService;


    @Scheduled(cron ="0 0/5 * * * *")
    public void emplyeeImportTask(){

        logger.info("{}  调用Rose远程人员数据批量导入接口 定时任务准备执行>>>>>>>>>>>>",DateTimeUtils.currentDateTostr());
        //执行定时任务
        QueryResp queryResp= employeeService.importEmplyeesToRose();
        if(queryResp.getResult()){
            logger.info("{} Rose远程人员数据批量导入定时任务执行完毕 ！",DateTimeUtils.currentDateTostr());
        }
        else {
            logger.error("{} Rose远程人员数据批量导入定时任务执行出现异常 ! 异常信息：{}",DateTimeUtils.currentDateTostr(),queryResp.getMsg());
        }

    }


}
