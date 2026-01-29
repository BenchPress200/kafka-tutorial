package com.benchpress200.kafkatutorial.consumer;

import com.benchpress200.kafkatutorial.dto.PostCreateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PostConsumer {
    @KafkaListener(
            topics = "post",
            groupId = "sample-group"
    )
    public void consume(PostCreateEvent event) {
        log.info("소비 게시글: id={}, body={}", event.getId(), event.getBody());
    }
}
