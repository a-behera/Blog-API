package com.sprinfboot.blog.service;

import com.sprinfboot.blog.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, Long id);

    void deletePostById(long id);
}
