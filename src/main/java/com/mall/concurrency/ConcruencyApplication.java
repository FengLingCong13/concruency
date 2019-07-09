package com.mall.concurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConcruencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConcruencyApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean httpFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new HttpFilter2());
        registrationBean.addUrlPatterns("/threadLocal/*");
        return registrationBean;
    }

}
