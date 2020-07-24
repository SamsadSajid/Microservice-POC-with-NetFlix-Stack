package com.netflixstack.microservice.poc.zuulproxy.zullFilters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;


public class PostFilter extends ZuulFilter {

    @Override
    public Object run(){

        Instant stop = Instant.now();

        // get start value
        RequestContext ctx = getCurrentContext();
        Instant start = (Instant)ctx.get("starttime");

        long secondsDifference = ChronoUnit.MILLIS.between(start, stop);
        System.out.println("Call took " + secondsDifference + " milliseconds.");


        return null;
    }

    @Override
    public String filterType() {

        return "post";
    }

    @Override
    public int filterOrder() {

        return 1;
    }

    @Override
    public boolean shouldFilter() {

        return true;
    }
}
