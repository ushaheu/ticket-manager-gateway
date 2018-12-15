package com.odilium.ticket.management.kafka.interfaces;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface RedisChannel {

    @Output(value = "ticket-status")
    MessageChannel output();
}
