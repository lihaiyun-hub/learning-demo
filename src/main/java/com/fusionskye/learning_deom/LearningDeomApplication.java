package com.fusionskye.learning_deom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@SpringBootApplication
public class LearningDeomApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningDeomApplication.class, args);
    }

}
