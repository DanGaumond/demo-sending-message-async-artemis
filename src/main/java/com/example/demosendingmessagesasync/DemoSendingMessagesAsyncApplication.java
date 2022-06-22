package com.example.demosendingmessagesasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
public class DemoSendingMessagesAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSendingMessagesAsyncApplication.class, args);
    }

}
