package com.yedam.tfprj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@SpringBootApplication
public class TfprjApplication {

    public static void main(String[] args) {
        SpringApplication.run(TfprjApplication.class, args);
    }

}
