package io.github.luankuhlmann.springbootblogrestapi.service;

import io.github.luankuhlmann.springbootblogrestapi.dto.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getPostById(long id);
}
