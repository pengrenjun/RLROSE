package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 主数据微服务启动类
 * 
 * @author <a href="mailto:fengj@emrubik.com">fengj</a>
 * @version $Revision 1.0 $ 2018年02月09日 上午9:50:14
 */
//扫描rose-generator-dao工程模块和rose-orgmicro工程模块里面的mapper文件
@MapperScan(basePackages={"com.emrubik.rosemail.generator.dao","com.emrubik.rose.modules.**.*"})
@SpringBootApplication
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
