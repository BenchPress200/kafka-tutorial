package com.benchpress200.kafkatutorial.service;

import com.benchpress200.kafkatutorial.dto.PostCreateRequest;
import com.benchpress200.kafkatutorial.entity.Post;
import com.benchpress200.kafkatutorial.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public void createPost(PostCreateRequest request) {
        Post post = request.toEntity();
        postRepository.save(post);
    }
}
