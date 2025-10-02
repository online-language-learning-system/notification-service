package com.hub.notification_service.repository;

import com.hub.notification_service.model.NotificationContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationContentRepository
        extends JpaRepository<NotificationContent, Long> {
}
