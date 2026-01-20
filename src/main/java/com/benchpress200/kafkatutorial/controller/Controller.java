package com.benchpress200.kafkatutorial.controller;

import com.benchpress200.kafkatutorial.dto.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Controller {
    private static final String TOPIC = "test.event";
    private final KafkaTemplate<String, Event> kafkaTemplate;

    @GetMapping("/event")
    public ResponseEntity<String> sendEvent() {
        kafkaTemplate.send(
                TOPIC,
                "1",
                new Event("event")
        ).whenComplete((result, ex) -> {
            if(ex == null) {
                log.info("이벤트 발행 성공");
            } else {
                log.error("이벤트 발행 실패");
            }
        });

        return ResponseEntity.ok("이벤트 발행 완료");
    }
}
