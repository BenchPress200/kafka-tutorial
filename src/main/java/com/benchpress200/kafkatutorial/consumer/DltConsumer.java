package com.benchpress200.kafkatutorial.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DltConsumer {

    @KafkaListener(
            topics= "test.event.dlt",
            groupId = "sample-group"
    )
    public void consume(String event) {
        log.info("처리 실패 데드 레터");
    }
}
