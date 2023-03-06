package com.ApiCall.demo.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class MicrositeConfiguration {
    public int isAmountEditable;
    public String welcomeMsg;
    public String label1;
    public String placeholder1;
    public String label2;
    public String placeholder2;
    public String label3;
    public String placeholder3;
    @JsonProperty("welcomeMsg-sw")
    public String welcomeMsg_sw;
    @JsonProperty("label1-sw")
    public String label1_sw;
    @JsonProperty("placeholder1-sw")
    public String placeholder1_sw;
    @JsonProperty("label2-sw")
    public String label2_sw;
    @JsonProperty("placeholder2-sw")
    public String placeholder2_sw;
    @JsonProperty("label3-sw")
    public String label3_sw;
    @JsonProperty("placeholder3-sw")
    public String placeholder3_sw;
    @JsonProperty("welcomeMsg-fr")
    public String welcomeMsg_fr;
    @JsonProperty("label1-fr")
    public String label1_fr;
    @JsonProperty("placeholder1-fr")
    public String placeholder1_fr;
    @JsonProperty("label2-fr")
    public String label2_fr;
    @JsonProperty("placeholder2-fr")
    public String placeholder2_fr;
    @JsonProperty("label3-fr")
    public String label3_fr;
    @JsonProperty("placeholder3-fr")
    public String placeholder3_fr;
}
