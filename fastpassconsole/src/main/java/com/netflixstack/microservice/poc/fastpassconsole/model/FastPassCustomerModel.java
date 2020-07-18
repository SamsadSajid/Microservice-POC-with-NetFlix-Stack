package com.netflixstack.microservice.poc.fastpassconsole.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FastPassCustomerModel {

    private String fastPassId;
    private String customerFullName;
    private String fastPassPhone;
    private BigDecimal currentBalance;
}
