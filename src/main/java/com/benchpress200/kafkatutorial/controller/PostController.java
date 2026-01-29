package com.benchpress200.kafkatutorial.controller;

import com.benchpress200.kafkatutorial.dto.PostCreateRequest;
import com.benchpress200.kafkatutorial.service.PostService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {
    private static final String TOPIC = "test.event";
    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<String> createPost(
            @RequestBody PostCreateRequest request
    ) {
        postService.createPost(request);
        return ResponseEntity.created(URI.create("")).build();
    }
}
