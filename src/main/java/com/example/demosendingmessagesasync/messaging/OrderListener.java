package com.example.demosendingmessagesasync.messaging;

import com.example.demosendingmessagesasync.model.Order;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class OrderListener {

    @JmsListener(destination = "${demo.queue.name}")
    public void receiveOrder(Order order) {
        System.out.println("Received an order!");
        System.out.println(order.toString());
    }

}
