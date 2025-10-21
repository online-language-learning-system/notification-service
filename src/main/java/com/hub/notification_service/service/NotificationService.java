package com.hub.notification_service.service;

import com.hub.common_library.exception.NotFoundException;
import com.hub.notification_service.model.Notification;
import com.hub.notification_service.model.NotificationContent;
import com.hub.notification_service.model.dto.ContentDetailGetDto;
import com.hub.notification_service.model.dto.ContentPostDto;
import com.hub.notification_service.model.dto.NotificationPostDto;
import com.hub.notification_service.model.enumeration.NotificationStatus;
import com.hub.notification_service.repository.NotificationContentRepository;
import com.hub.notification_service.repository.NotificationDocumentRepository;
import com.hub.notification_service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationContentRepository notificationContentRepository;
    private final NotificationDocumentRepository notificationDocumentRepository;

    public ContentDetailGetDto viewNotificationContent(Long notificationContentId) {
        NotificationContent content = notificationContentRepository.findById(notificationContentId)
                .orElseThrow(() -> new NotFoundException("NotificationContent not found"));

        Notification notification = content.getNotification();
        if (notification.getNotificationStatus() != NotificationStatus.READ) {
            notification.setNotificationStatus(NotificationStatus.READ);
            notificationRepository.save(notification);
        }

        return ContentDetailGetDto.fromModel(content);
    }

    public void sendNotification(NotificationPostDto notificationPostDto) {
        Notification notification = new Notification();
        notification.setRecipient(notificationPostDto.recipient());
        Notification savedNotification = notificationRepository.save(notification);

        // Set content to notify
        savedNotification.getNotificationContents()
                .add(setNotificationContent(notificationPostDto.notificationContent(), savedNotification));

        if (notificationPostDto.notificationStatus() == null)
            savedNotification.setNotificationStatus(NotificationStatus.SENT);

        notificationRepository.save(notification);
    }

    public NotificationContent setNotificationContent(ContentPostDto contentPostDto, Notification notification) {
        NotificationContent content = new NotificationContent();
        content.setContent(contentPostDto.content());
        content.setNotification(notification);
        return notificationContentRepository.save(content);
    }
}
