package com.ApiCall.demo.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class Bill{
    public int billID;
    public int billingServiceID;
    public String uniqueHash;
    public String accountNumber;
    public String accountName;
    public double dueAmount;
    public int isAmountEditable;
    public double paidAmount;
    public String deliveryChannel;
    public String email;
    public Object billFileID;
    public String currencyCode;
    public Date dueDate;
    public int sendStatus;
    public int paymentStatus;
    public String countryCode;
    public Object billCycleID;
    public Date dateCreated;
    public BillConfig billConfig;
    public String requestOrigin;
    public Date dateModified;
    public int status;
    public String msisdn;
}


