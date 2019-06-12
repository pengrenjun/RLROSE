package com.emrubik.rose.modules.dept.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: sunyingji
 * @create: 2019-03-19 14:26
 **/
@RestController
public class DeptController {


    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;



    @GetMapping("/depts")
    public void  get() throws SQLException {




        /*String forObject = restTemplate.getForObject("http://10.10.20.47:8080/depts", String.class);*/
       /* ResponseEntity<Dept[]> forEntity = restTemplate.getForEntity("http://10.10.20.47:8080/depts", Dept[].class);*/
        /*System.out.println(forEntity);*/


        logger.info("11111111111111111");





    }
}
