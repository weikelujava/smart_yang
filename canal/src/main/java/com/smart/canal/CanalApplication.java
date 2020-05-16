package com.smart.canal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableElasticsearchRepositories(basePackages = "com.smart.canal.repository")
@SpringBootApplication
public class CanalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CanalApplication.class, args);
    }

}
