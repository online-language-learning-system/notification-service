package com.hub.notification_service.service;

import com.hub.notification_service.repository.NotificationContentRepository;
import com.hub.notification_service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationContentRepository notificationContentRepository;
    private final NotificationRepository notificationRepository;


}
