package com.example.demosendingmessagesasync.config;

import com.example.demosendingmessagesasync.model.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MessagingConfig {
    @Bean
    public MappingJackson2MessageConverter messageConverter() {
        MappingJackson2MessageConverter messageConverter =
                new MappingJackson2MessageConverter();
        messageConverter.setTypeIdPropertyName("_typeId");

        // Specify all possible mapping here
        Map<String, Class<?>> typeIdMappings = new HashMap<>();
        typeIdMappings.put("order", Order.class);
        messageConverter.setTypeIdMappings(typeIdMappings);

        return messageConverter;
    }
}
