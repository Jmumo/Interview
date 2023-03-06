package com.ApiCall.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class config {
    private String BaseUrl = "https://paybylink-apis.dev.tingg.africa/paybylink-apis";
    private String FirstRequestUrl = "/api/merchant/microsite/dynamic?billHash=3837&paymentChannel=USSD";
    private String SecondRequestUrl = "/api/merchant/microsite/routing/charge";
}
