package com.netflixstack.microservice.poc.fastpassservice.controller;

import com.netflixstack.microservice.poc.fastpassservice.model.FastPassCustomerModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@RestController
public class FastPassController {

    List<FastPassCustomerModel> customerlist = new ArrayList<>();

    public FastPassController() {

        FastPassCustomerModel fc1 = new FastPassCustomerModel(
                "100", "Richard Seroter", "555-123-4567",
                new BigDecimal("19.50")
        );

        FastPassCustomerModel fc2 = new FastPassCustomerModel(
                "101", "Jason Salmond", "555-321-7654",
                new BigDecimal("11.25")
        );

        FastPassCustomerModel fc3 = new FastPassCustomerModel(
                "102", "Lisa Szpunar", "555-987-6543",
                new BigDecimal("35.00")
        );

        customerlist.add(fc1);
        customerlist.add(fc2);
        customerlist.add(fc3);
    }


    @RequestMapping(path="/fastpass", params={"fastpassid"})
    public FastPassCustomerModel getFastPassById(@RequestParam String fastpassid) {

        Predicate<FastPassCustomerModel> p = c-> c.getFastPassId().equals(fastpassid);
        FastPassCustomerModel customer = customerlist.stream().filter(p).findFirst().get();
        System.out.println("customer details retrieved");
        return customer;
    }

    @RequestMapping(path="/fastpass", params={"fastpassphone"})
    public FastPassCustomerModel getFastPassByPhone(@RequestParam String fastpassphone) {

        Predicate<FastPassCustomerModel> p = c-> c.getFastPassPhone().equals(fastpassphone);
        Optional<FastPassCustomerModel> filteredCustomerList = customerlist.stream().filter(p).findFirst();

        var cus = new FastPassCustomerModel();

        filteredCustomerList.ifPresentOrElse(customer ->{
            System.out.println("Details retrieved for customer: ");

            cus.setCustomerFullName(customer.getCustomerFullName());
            cus.setFastPassId(customer.getFastPassId());
            cus.setFastPassPhone(customer.getFastPassPhone());
            cus.setCurrentBalance(customer.getCurrentBalance());
        }, () -> {throw new NullPointerException();});

        System.out.println(cus);
        return cus;
    }
}
