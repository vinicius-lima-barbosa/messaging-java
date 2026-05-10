package com.messagingjava.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQ {

    @Bean
    public Queue notificationQueue() {
        return new Queue("notification.queue");
    }
}
