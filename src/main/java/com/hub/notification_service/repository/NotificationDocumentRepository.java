package com.hub.notification_service.repository;

import com.hub.notification_service.model.NotificationDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationDocumentRepository
        extends MongoRepository<NotificationDocument, String> {
}
