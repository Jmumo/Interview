package com.ApiCall.demo;

import com.ApiCall.demo.Dtos.BillRequest;
import com.ApiCall.demo.Dtos.Root;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class ApiCallTest {


    private Environment env;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    OkHttpClient client = new OkHttpClient();

    @Test
    public void ShouldMakeApiCall() {

        String BASE_URL = "https://paybylink-apis.dev.tingg.africa/paybylink-apis";
        String requestUrl = "/api/merchant/microsite/dynamic?billHash=3837&paymentChannel=USSD";
        Request request = new Request.Builder()
                .url(BASE_URL + requestUrl)
                .build();
        Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertThat(response.code(), equalTo(200));
    }
}


