package com.netflixstack.microservice.poc.fastpassconsole.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class FastPassServiceRoutingConfig {

    @Autowired
    IClientConfig ribbonClientConfig;

    @Bean
    public IRule ribbonRule(IClientConfig iClientConfig) {

        return new WeightedResponseTimeRule();
    }
}
