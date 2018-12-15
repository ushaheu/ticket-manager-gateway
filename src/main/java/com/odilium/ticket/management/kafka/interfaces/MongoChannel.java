package com.odilium.ticket.management.kafka.interfaces;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MongoChannel {

    @Output(value = "ticket-manager-logs")
    MessageChannel output();
}
