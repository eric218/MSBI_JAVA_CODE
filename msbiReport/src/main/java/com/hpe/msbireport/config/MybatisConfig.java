package com.hpe.msbireport.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 27/12/17
 * Description: Specify mybatis configuration file path, so that springboot can auto load the configuration file.
 */
@Configuration
@ImportResource({"classpath:/config/spring-mybatis.xml"})
public class MybatisConfig {
}
