package com.orderfulfilmentapplication.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderfulfilmentapplication.configuration.MessagingConfig;

@Service
public class NotificationService {
	@Autowired
	private RabbitTemplate template;
	
	public String publish(Object o) {
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, o);
        return "Success !!";
    }

}
