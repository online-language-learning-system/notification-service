package com.hub.notification_service.kafka;

import com.hub.notification_service.kafka.event.OrderPaidEvent;
import com.hub.notification_service.model.dto.ContentPostDto;
import com.hub.notification_service.model.dto.NotificationPostDto;
import com.hub.notification_service.model.enumeration.NotificationStatus;
import com.hub.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class NotificationConsumer {

    private final NotificationService notificationService;

    @Bean
    public Consumer<OrderPaidEvent> sendSuccessOrderNotification() {
        return orderPaidEvent -> {
            ContentPostDto content = new ContentPostDto("Khoá học của bạn đã thanh toán thành công");
            NotificationPostDto notification = new NotificationPostDto(
                    orderPaidEvent.studentId(),
                    content,
                    NotificationStatus.SENT
            );

            notificationService.sendNotification(notification);
        };
    }

}
