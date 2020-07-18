package com.netflixstack.microservice.poc.fastpassconsole.controller;

import com.netflixstack.microservice.poc.fastpassconsole.model.FastPassCustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class fastPassCustomerController {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(path="/customerdetails", params={"fastpassid"})
    public FastPassCustomerModel getFastPassCustomerDetails(@RequestParam String fastpassid) {

        FastPassCustomerModel c = restTemplate.getForObject("http://fastpass-service/fastpass?fastpassid=" + fastpassid, FastPassCustomerModel.class);
        System.out.println("Retrieved customer details: ");
        System.out.println(c);

        return c;
    }

    @GetMapping(path="/customerdetails", params={"fastpassphone"})
    public FastPassCustomerModel getFastPassCustomerDetailsWithPhone(@RequestParam String fastpassphone) {

        FastPassCustomerModel c = restTemplate.getForObject("http://fastpass-service/fastpass?fastpassphone=" + fastpassphone, FastPassCustomerModel.class);
        System.out.println("Retrieved customer details: ");
        System.out.println(c);

        return c;
    }
}
