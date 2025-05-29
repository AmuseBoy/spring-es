package com.amuseboy.springes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories(basePackages = "com.amuseboy.springes.dao")
@SpringBootApplication
public class SpringEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEsApplication.class, args);
    }

}
