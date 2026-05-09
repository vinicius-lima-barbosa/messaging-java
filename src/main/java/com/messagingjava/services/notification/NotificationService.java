package com.messagingjava.services.notification;

import java.util.List;
import java.util.UUID;

import com.messagingjava.domain.notification.CreateNotificationDTO;
import org.springframework.stereotype.Service;

import com.messagingjava.domain.notification.NotificationResponseDTO;
import com.messagingjava.entities.notification.NotificationEntity;
import com.messagingjava.repositories.notification.NotificationRepository;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    private NotificationResponseDTO toDto(NotificationEntity notification) {
        return new NotificationResponseDTO(
            notification.getId(),
            notification.getTitle(),
            notification.getMessage(),
            notification.getRecipient(),
            notification.getStatus().name(),
            notification.getCreatedAt()
        );
    }

    public List<NotificationResponseDTO> findAll() {
        return notificationRepository.findAll().stream().map(this::toDto).toList();
    }

    public NotificationResponseDTO findById(UUID id) {
        NotificationEntity notification = notificationRepository.findById(id).orElseThrow(() -> new RuntimeException("Notification not found!"));

        return toDto(notification);
    }

    public NotificationResponseDTO create(CreateNotificationDTO dto) {
        NotificationEntity notification = new NotificationEntity();

        notification.setTitle(dto.title());
        notification.setMessage(dto.message());
        notification.setRecipient(dto.recipient());

        NotificationEntity saved = notificationRepository.save(notification);

        return toDto(saved);
    }
}
