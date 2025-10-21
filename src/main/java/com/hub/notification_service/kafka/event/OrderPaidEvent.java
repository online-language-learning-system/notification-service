package com.hub.notification_service.kafka.event;

import java.util.List;

public record OrderPaidEvent(
        String studentId,
        List<Long> courseIds
) {
}
