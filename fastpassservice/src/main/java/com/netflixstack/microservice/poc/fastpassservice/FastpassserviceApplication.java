package com.netflixstack.microservice.poc.fastpassservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FastpassserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastpassserviceApplication.class, args);
	}

}
