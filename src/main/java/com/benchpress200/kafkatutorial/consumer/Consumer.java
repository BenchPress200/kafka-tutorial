package com.benchpress200.kafkatutorial.consumer;

import com.benchpress200.kafkatutorial.dto.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.BackOff;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {
    @KafkaListener(
            topics = "test.event",
            groupId = "sample-group"
    )
    @RetryableTopic(
            attempts = "5",
            backOff = @BackOff(delay = 1000),
            dltTopicSuffix = ".dlt"
    )
    public void consume(Event event) {
        log.info("소비 메시지: {}", event.getMessage());
    }
}
