package com.netflixstack.microservice.poc.zuulproxy.zullFilters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import java.time.Instant;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;


public class PreFilter extends ZuulFilter {

    @Override
    public Object run() {

        RequestContext ctx = getCurrentContext();
        System.out.println(Instant.now());

        ctx.set("starttime", Instant.now());

        return null;
    }

    @Override
    public String filterType() {

        return "pre";
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
