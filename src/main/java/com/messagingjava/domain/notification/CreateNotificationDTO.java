package com.messagingjava.domain.notification;

import jakarta.validation.constraints.NotBlank;

public record CreateNotificationDTO(
    @NotBlank
    String title,

    @NotBlank
    String message,

    @NotBlank
    String recipient
) {}
