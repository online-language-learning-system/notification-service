package com.hub.notification_service.model;

import com.hub.common_library.model.AbstractAuditEntity;
import com.hub.notification_service.model.enumeration.NotificationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notification", schema = "dbo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notification extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "notification_content_id")
    private NotificationContent notificationContent;

    private String recipient;

    @Column(name = "notification_status")
    private NotificationStatus notificationStatus;

}