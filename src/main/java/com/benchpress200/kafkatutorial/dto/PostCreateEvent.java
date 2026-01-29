package com.benchpress200.kafkatutorial.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCreateEvent {
    private Long id;
    private String body;
}
