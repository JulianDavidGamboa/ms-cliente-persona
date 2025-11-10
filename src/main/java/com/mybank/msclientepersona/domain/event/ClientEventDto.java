package com.mybank.msclientepersona.domain.event;

public record ClientEventDto(
        String eventId,
        String eventType,
        String clientId,
        String name
) {
}
