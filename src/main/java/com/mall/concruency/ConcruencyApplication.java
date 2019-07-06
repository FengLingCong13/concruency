package com.mall.concruency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConcruencyApplication {

    public static void main(String[] args) {
        System.out.println(888);
        SpringApplication.run(ConcruencyApplication.class, args);
    }

}
