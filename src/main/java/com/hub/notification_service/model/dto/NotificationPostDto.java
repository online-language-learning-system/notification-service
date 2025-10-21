package com.hub.notification_service.model.dto;

import com.hub.notification_service.model.enumeration.NotificationStatus;

public record NotificationPostDto(
        String recipient,
        ContentPostDto notificationContent,
        NotificationStatus notificationStatus
) {
}
