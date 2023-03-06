package com.ApiCall.demo;


import com.ApiCall.demo.Dtos.BillRequest;
import com.ApiCall.demo.Dtos.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class ApiCall {
    OkHttpClient client = new OkHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();
    config config = new config();
    public void makeApiCall(){
        Request request = new Request.Builder()
                .url(config.getBaseUrl()+config.getFirstRequestUrl())
                .build();
        Call call = client.newCall(request);
        Response response;
        {
            try {
                response = call.execute();
                assert response.body() != null;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
            Root root = objectMapper.readValue(response.body().string(), Root.class);
             makeSecondCall(root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void makeSecondCall(Root root) {
        BillRequest bill = new BillRequest();
        bill.originatorMSISDN = root.bill.msisdn;
        bill.payerClientCode = "SAFKE";
        bill.payerClientName = "M-PESA";
        bill.checkoutType = "USSD_PUSH";
        bill.currencyCode = root.bill.currencyCode;
        bill.requestOrigin = "TINGG_SUBSCRIPTIONS_WEB";
        bill.msisdn = root.bill.msisdn;
        bill.language = "en";
        bill.accountNumber = root.bill.accountNumber;
        bill.invoiceNumber = "";
        bill.countryCode = root.bill.currencyCode;
        bill.amount = root.bill.dueAmount;
        bill.description = "Payment for a bill";
        bill.billingServiceID = root.billingServiceResponse.billingServiceID;
        bill.billHash = root.bill.billID;
        bill.paymentChannel = "paybill";
        bill.paymentCode = "589036";

        MediaType JSON
                = MediaType.get("application/json; charset=utf-8");
        RequestBody formBody;
        try {
            formBody = RequestBody.create(objectMapper.writeValueAsString(bill),JSON);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Request request = new Request.Builder()
                .url(config.getBaseUrl()+config.getSecondRequestUrl())
                .post(formBody)
                .build();
        Call secondCall = client.newCall(request);
        {
            try {
                Response response = secondCall.execute();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }




}
