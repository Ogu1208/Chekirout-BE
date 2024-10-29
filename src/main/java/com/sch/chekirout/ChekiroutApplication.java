package com.sch.chekirout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableJpaAuditing
@SpringBootApplication
@EnableAsync
public class ChekiroutApplication {

    //브랜치 확인
    public static void main(String[] args) {
        SpringApplication.run(ChekiroutApplication.class, args);
    }

}
