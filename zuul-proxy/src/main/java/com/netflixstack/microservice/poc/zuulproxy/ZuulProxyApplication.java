package com.netflixstack.microservice.poc.zuulproxy;

import com.netflixstack.microservice.poc.zuulproxy.zullFilters.PostFilter;
import com.netflixstack.microservice.poc.zuulproxy.zullFilters.PreFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ZuulProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulProxyApplication.class, args);
    }

    @Bean
    public PreFilter preFilter() {

        return new PreFilter();
    }

    @Bean
    public PostFilter postFilter() {

        return new PostFilter();
    }
}
