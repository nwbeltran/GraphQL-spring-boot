package com.example.bff.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Authentication {
    private String requestID;
    private int appId;
    private int templateNumberSms;
    private int templateNumberEmail;
    private boolean previouslyAuthenticated;
    private boolean retake;
    private String correlationIDVerify;
    private String destinationVerify;
    private String finalStateVerify;
    private String correlationIDSign;
    private String destinationSign;
    private String finalStateSign;
}
