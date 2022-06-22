package com.example.demosendingmessagesasync.messaging;

import com.example.demosendingmessagesasync.model.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsOrderReceiver implements OrderReceiver {

    @Value("${demo.queue.name}")
    private String queueName;

    private final JmsTemplate jms;

    public JmsOrderReceiver(JmsTemplate jms) {
        this.jms = jms;
    }

    @Override
    public Order receiveOrder() {
        return (Order) jms.receiveAndConvert(queueName);
    }
}
