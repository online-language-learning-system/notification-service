package com.hub.notification_service.model;

import com.hub.notification_service.model.enumeration.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "notification_content", schema = "dbo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    private EventType eventType;

    private String content;

    @OneToMany(mappedBy = "notificationContent")
    private List<Notification> notifications = new ArrayList<>();

}
