package com.messagingjava.queues.notification;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class NotificationPublisher {
    private final RabbitTemplate rabbitTemplate;

    public NotificationPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishNotification(UUID notificationId) {
        rabbitTemplate.convertAndSend(
                "notification.queue",
                notificationId.toString()
        );

        System.out.println("Mensagem enviada para a fila");
    }
}
