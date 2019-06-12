package test;

import com.Boot;
import com.emrubik.entity.employee.bean.EmployeeEntity;
import com.emrubik.rose.config.RestTemplateUrlConfig;
import com.emrubik.rose.generator.dao.EmplyeePoMapper;
import com.emrubik.rose.generator.dao.bean.EmplyeePo;
import com.emrubik.rose.generator.dao.bean.EmplyeePoExample;
import com.emrubik.rose.modules.employee.mapper.EmployEntitiyMapper;
import com.emrubik.rose.modules.employee.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description TODO
 * @Date 2019/3/20 0020 上午 10:19
 * @Created by Pengrenjun
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {Boot.class})
public class EmployeeImportTest {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployEntitiyMapper employEntitiyMapper;

    @Autowired
    private RestTemplateUrlConfig restTemplateUrlConfig;

    @Autowired
    private EmplyeePoMapper emplyeePoMapper;



    //测试Rose查询接口 所需的人员数据查询
    @Test
    public void getEmployeesEntities(){
        restTemplateUrlConfig.getEmplyeeImportUrl();
        restTemplateUrlConfig.getJobCodeImportUrl();
        List<EmployeeEntity> allEmployees = employEntitiyMapper.getAllEmployees();
         System.out.println(allEmployees.size());

     }

     //测试Rose导入接口
     @Test
    public void testImportEmplyess(){
         employeeService.importEmplyeesToRose();
     }

     @Test
     public void testGetEmployPos(){
         EmplyeePoExample emplyeePoExample=new EmplyeePoExample();
         EmplyeePoExample.Criteria criteria = emplyeePoExample.createCriteria();
         //查询有效非虚拟的用户
         criteria.andEffdtStatusEqualTo("A").andStaffNoNotLike("XN%");
         List<EmplyeePo> emplyeePoList = emplyeePoMapper.selectByExample(emplyeePoExample);

         System.out.println(emplyeePoList);

     }


}
