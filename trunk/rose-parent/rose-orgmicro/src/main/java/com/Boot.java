package com;

import com.emrubik.rose.config.RestTemplateUrlConfig;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 主数据微服务启动类
 * 
 * @author <a href="mailto:fengj@emrubik.com">fengj</a>
 * @version $Revision 1.0 $ 2018年02月09日 上午9:50:14
 */
//扫描rose-generator-dao工程模块和rose-orgmicro工程模块里面的mapper文件
@MapperScan(basePackages={"com.emrubik.rose.generator.dao","com.emrubik.rose.modules.**.*"})
@EnableScheduling
@SpringBootApplication
@EnableConfigurationProperties({RestTemplateUrlConfig.class})
public class Boot {

    /**
     * init 初始化
     */
    public void init() {
        System.out.println("系统启动...");
    }

    /**
     * 启动类
     * 
     * @param args
     *            参数
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(Boot.class).web(true).run(args);
    }

}
