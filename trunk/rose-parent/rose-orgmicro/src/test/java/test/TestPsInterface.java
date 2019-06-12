package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.emrubik.entity.employee.bean.EmployeeEntity;
import com.emrubik.rose.Utils.HttpClientResult;
import com.emrubik.rose.Utils.HttpClientUtils;
import com.emrubik.rose.generator.dao.bean.EmplyeePo;

import java.util.List;

/**
 * @Description 测试Ps对外提供的接口
 * @Date 2019/5/22 0022 上午 9:26
 * @Created by Pengrenjun
 */
public class TestPsInterface {

    public static void main(String[] args) {

        testgetPsAllEmployeeDate();
    }

    //远程调用197上的接口获取人员数据
    private static void testgetPsAllEmployeeDate() {

        try {
            HttpClientResult httpClientResult=HttpClientUtils.getForObjectByUrl("http://10.0.99.197:8001/pssoft/getPsAllEmployeeDate");
            String date=httpClientResult.getContent();

            List<EmplyeePo> employeeEntities=JSON.parseObject(date,new TypeReference<List<EmplyeePo>>() {});

            System.out.println(employeeEntities.size());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
