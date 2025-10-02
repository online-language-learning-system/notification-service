package com.hub.notification_service.model;

import com.hub.notification_service.model.enumeration.NotificationStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Map;

@Getter
@Setter
@Document(collection = "notification_document")
public class NotificationDocument {

    @Id
    private String id;

    private String recipient;

    private NotificationStatus status;

    private String eventType;

    private String title;

    private String message;

    private Map<String, Object> payload;

    @CreatedBy
    private String createdBy;

    @CreationTimestamp
    private OffsetDateTime createdOn;

    @LastModifiedBy
    private String lastModifiedBy;

    @UpdateTimestamp
    private OffsetDateTime lastModifiedOn;

}
