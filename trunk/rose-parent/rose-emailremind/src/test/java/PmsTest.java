import com.Boot;
import com.alibaba.fastjson.JSON;
import com.emrubik.rose.generator.dao.DeptPoMapper;
import com.emrubik.rose.generator.dao.bean.DeptPo;
import com.emrubik.rose.generator.dao.bean.DeptPoExample;
import com.emrubik.rosemail.generator.dao.PmsEmailOidPoMapper;
import com.emrubik.rosemail.generator.dao.PssEmailPoMapper;
import com.emrubik.rosemail.generator.dao.bean.PmsEmailOidPo;
import com.emrubik.rosemail.generator.dao.bean.PmsEmailOidPoExample;
import com.emrubik.rosemail.generator.dao.bean.PssEmailPo;
import com.emrubik.rosemail.generator.dao.bean.PssEmailPoExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 测试
 * @author: sunyingji
 * @create: 2019-04-16 20:58
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {Boot.class})
public class PmsTest {

    @Autowired
    private PmsEmailOidPoMapper pmsEmailOidPoMapper;
    @Autowired
    private PssEmailPoMapper pssEmailPoMapper;

    @Test
    public void test01(){

        //查询出所有部门数据
        PmsEmailOidPoExample deptPoExample=new PmsEmailOidPoExample();
        deptPoExample.createCriteria().andOidIsNotNull();
        List<PmsEmailOidPo> deptPos = pmsEmailOidPoMapper.selectByExample(deptPoExample);
        System.out.println(deptPos);


        PssEmailPoExample pssEmailPoExample=new PssEmailPoExample();
        pssEmailPoExample.createCriteria().andMoidIsNotNull();
        List<PssEmailPo> pssEmailPos = pssEmailPoMapper.selectByExample(pssEmailPoExample);
        System.out.println(pssEmailPos);
    }

    @Test
    public void test(){

        RestTemplate restTemplate=new RestTemplate();
        Map<String,Object> map1=new HashMap<>();
        Map<String,Object> map2=new HashMap<>();

        List<Map<String,Object>> list=new ArrayList<>();
        map2.put("process_instance_id","123123");
        map2.put("process_instance_name","测试流程");
        map2.put("reject_reason","测试");
        map2.put("submitter_email","798@qq.com");
        map2.put("submitter_name","小明");
        map2.put("update_time","2019-04-19 12:55:00");

        list.add(map2);
        map1.put("data",list);

        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Content-Type","application/json;charset=UTF-8");
        HttpEntity<String> httpEntity=new HttpEntity<>(JSON.toJSONString(map1),httpHeaders);
        Map postobj=restTemplate.postForObject("http://10.0.99.197:8006//v1.0/message/rejectToSubmitterNotification",httpEntity,Map.class);

        System.out.println(postobj);





    }
}
