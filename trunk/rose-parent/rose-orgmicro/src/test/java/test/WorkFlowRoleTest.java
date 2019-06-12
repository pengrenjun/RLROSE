package test;

import com.Boot;
import com.emrubik.rose.generator.dao.bean.RoseWorkflowPo;
import com.emrubik.rose.modules.workflowRole.service.WorkFlowRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description TODO
 * @Date 2019/3/20 0020 上午 11:40
 * @Created by Pengrenjun
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {Boot.class})
public class WorkFlowRoleTest {

    @Autowired
    private WorkFlowRoleService workFlowRoleService;

    @Test
    public void getWorkFlowRoles(){
        workFlowRoleService.importWorkflowRolesToRose();
    }




}
