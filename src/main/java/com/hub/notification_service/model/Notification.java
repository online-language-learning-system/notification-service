package com.hub.notification_service.model;

import com.hub.common_library.model.AbstractAuditEntity;
import com.hub.notification_service.model.enumeration.NotificationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    private String recipient;

    @Column(name = "notification_status")
    private NotificationStatus notificationStatus;

    @OneToMany(mappedBy = "notification")
    @JoinColumn(name = "notification_content_id")
    private List<NotificationContent> notificationContents = new ArrayList<>();
}