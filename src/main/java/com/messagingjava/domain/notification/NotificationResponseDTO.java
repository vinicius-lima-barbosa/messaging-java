package com.messagingjava.domain.notification;

import java.time.LocalDateTime;
import java.util.UUID;

public record NotificationResponseDTO(
    UUID id,
    String title,
    String message,
    String recipient,
    String status,
    LocalDateTime createdAt
) {}
