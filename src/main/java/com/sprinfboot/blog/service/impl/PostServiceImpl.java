package com.sprinfboot.blog.service.impl;

import com.sprinfboot.blog.entity.Post;
import com.sprinfboot.blog.exception.ResourceNotFoundException;
import com.sprinfboot.blog.payload.PostDto;
import com.sprinfboot.blog.repository.PostRepository;
import com.sprinfboot.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {


    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        //convert Dto to entity
        Post post = mapToEntity(postDto);

        Post newPost = postRepository.save(post);

        //convert entity to Dto
        PostDto postResponse = mapToDto(newPost);

        return postResponse;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","Id",id));
        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long id) {
        Post post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","Id",id));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post updatedPost = postRepository.save(post);

        return mapToDto(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","Id",id));
        postRepository.delete(post);
    }

    //entity To Dto
    private PostDto mapToDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getDescription());

        return postDto;
    }

    private Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getDescription());

        return post;
    }
}


