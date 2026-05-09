package com.messagingjava.controllers.notification;

import com.messagingjava.domain.notification.CreateNotificationDTO;
import com.messagingjava.domain.notification.NotificationResponseDTO;
import com.messagingjava.services.notification.NotificationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public List<NotificationResponseDTO> findAll() {
        return notificationService.findAll();
    }

    @GetMapping("/{id}")
    public NotificationResponseDTO findById(@PathVariable("id") UUID id) {
        return notificationService.findById(id);
    }

    @PostMapping
    public NotificationResponseDTO create(@RequestBody @Valid CreateNotificationDTO data) {
        return notificationService.create(data);
    }
}
