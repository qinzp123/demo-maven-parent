package com.qinzp.official;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
Spring Boot + JPA 多模块项目，启动报异常找不到bean,是因为jpa的Entity和Repository不在启动程序同级子包下，
在启动类添加  @EnableJpaRepositories, @EntityScan 注解即可
 */
@SpringBootApplication
@ComponentScan({"com.qinzp"})// 1. 多模块项目需要扫描的包
@EnableJpaRepositories("com.qinzp")// 2. Dao 层所在的包
@EntityScan("com.qinzp")// 3. Entity 所在的包
public class OfficialApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfficialApplication.class, args);
    }

}
