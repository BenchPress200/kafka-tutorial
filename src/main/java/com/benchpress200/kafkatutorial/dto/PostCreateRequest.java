package com.benchpress200.kafkatutorial.dto;

import com.benchpress200.kafkatutorial.entity.Post;
import lombok.Getter;

@Getter
public class PostCreateRequest {
    private String body;

    public Post toEntity() {
        return new Post(body);
    }
}
