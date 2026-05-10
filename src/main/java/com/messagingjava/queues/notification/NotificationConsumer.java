package com.messagingjava.queues.notification;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    @RabbitListener(queues = "notification.queue")
    public void consume(String notificationId) {
            System.out.println("Mensagem recebida da fila: " + notificationId);
    }
}
