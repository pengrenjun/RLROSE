package test;

import com.Boot;
import com.emrubik.entity.common.QueryResp;
import com.emrubik.rose.generator.dao.DeptPoMapper;
import com.emrubik.rose.generator.dao.RoseWorkflowPoMapper;
import com.emrubik.rose.generator.dao.bean.RoseWorkflowPo;
import com.emrubik.rose.generator.dao.bean.RoseWorkflowPoExample;
import com.emrubik.rose.modules.dept.service.DeptService;
import com.emrubik.rose.modules.jobcode.service.JobCodeService;
import com.emrubik.rose.modules.workflowRole.service.WorkFlowRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @description:
 * @author: sunyingji
 * @create: 2019-03-19 18:30
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {Boot.class})
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。

public class DaoTest {

    @Autowired
    private  RoseWorkflowPoMapper roseWorkflowPoMapper;

    @Autowired
    private JobCodeService jobCodeService;

    @Autowired
    private DeptService deptService;


    @Autowired
    private WorkFlowRoleService workFlowRoleService;
    
    
    


    @Test
    public void test(){
        /*RoseWorkflowPoExample roseWorkflowPoExample=new RoseWorkflowPoExample();
        RoseWorkflowPoExample.Criteria criteria = roseWorkflowPoExample.createCriteria();
        criteria.andWorkflowcodeIsNotNull();
        List<RoseWorkflowPo> list = roseWorkflowPoMapper.selectByExample(roseWorkflowPoExample);
        System.out.println(list);*/
        jobCodeService.importJobCodeInfoToRose();

    }


    @Test
    public void test2(){
        /*RoseWorkflowPoExample roseWorkflowPoExample=new RoseWorkflowPoExample();
        RoseWorkflowPoExample.Criteria criteria = roseWorkflowPoExample.createCriteria();
        criteria.andWorkflowcodeIsNotNull();
        List<RoseWorkflowPo> list = roseWorkflowPoMapper.selectByExample(roseWorkflowPoExample);
        System.out.println(list);*/
        /* jobCodeService.importJobCodeInfoToRose();*/
        deptService.importDeptInfoToRose();

    }

    @Test
    public void test3(){
        /*RoseWorkflowPoExample roseWorkflowPoExample=new RoseWorkflowPoExample();
        RoseWorkflowPoExample.Criteria criteria = roseWorkflowPoExample.createCriteria();
        criteria.andWorkflowcodeIsNotNull();
        List<RoseWorkflowPo> list = roseWorkflowPoMapper.selectByExample(roseWorkflowPoExample);
        System.out.println(list);*/
        /* jobCodeService.importJobCodeInfoToRose();*/
        workFlowRoleService.importWorkflowRolesToRose();

    }


}
