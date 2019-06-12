

/*******************************************************************************
 * @(#)SwaggerConfig.java 2017年3月4日
 *
 * Copyright 2017 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.rose.apidoc;

import com.emrubik.rose.modules.todoremind.controller.TodoRemindController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置
 * @author <a href="mailto:fengjian@emrubik.com">feng jian</a>
 * @version $Revision 1.0 $ 2017年3月4日 上午1:47:40
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${api.doc.desc}")
    private String apiDocDesc;

    @Value("${api.doc.title}")
    private String apiDocTitle;

    @Value("${api.doc.contact}")
    private String apiDocContact;

    @Value("${api.doc.version}")
    private String apiDocVer;

    @Value("${api.doc.path.mapping}")
    private String apiDocPathMapping;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("controller")
                .apiInfo(apiInfo())
                .pathMapping(apiDocPathMapping)
                .select().apis(RequestHandlerSelectors.any())
               /* .select().apis(RequestHandlerSelectors.basePackage(TodoRemindController.class.getPackage().getName()))*/
               /* .paths(PathSelectors.any())*/
                .paths(PathSelectors.ant("/v1.0/**"))
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(apiDocTitle)
                .description(apiDocDesc)
                .termsOfServiceUrl("http://springfox.io")
                .contact(apiDocContact)
                .license("apache license version 2.0")
                .licenseUrl("")
                .version(apiDocVer)
                .build();
    }
}