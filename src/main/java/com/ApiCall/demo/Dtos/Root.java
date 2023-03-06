package com.ApiCall.demo.Dtos;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Root {
    public Biller biller;
    public BillingServiceResponse billingServiceResponse;
    public Bill bill;
    public Object expiryDate;
    public boolean expired;
}
