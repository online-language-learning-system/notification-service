package com.hub.notification_service.model.dto;

import com.hub.notification_service.model.NotificationContent;

public record ContentDetailGetDto(
        Long notificationContentId,
        String content
) {
    public static ContentDetailGetDto fromModel(NotificationContent notificationContent) {
        return new ContentDetailGetDto(
                notificationContent.getId(),
                notificationContent.getContent()
        );
    }
}
