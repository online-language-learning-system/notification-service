package com.hub.notification_service.repository;

import com.hub.notification_service.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository
        extends JpaRepository<Notification, Long> {
}
