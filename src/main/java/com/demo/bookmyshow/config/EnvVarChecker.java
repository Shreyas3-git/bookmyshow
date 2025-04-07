package com.demo.bookmyshow.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvVarChecker {
    @Autowired
    private Environment env;

    @PostConstruct
    public void checkEnvVars() {
        System.out.println("TWILIO_ACCOUNT_SID: " + env.getProperty("TWILIO_ACCOUNT_SID"));
        System.out.println("TWILIO_SERVICE_SID: " + env.getProperty("TWILIO_SERVICE_SID"));
        System.out.println("TWILIO_AUTH_TOKEN: " + env.getProperty("TWILIO_AUTH_TOKEN"));
    }
}