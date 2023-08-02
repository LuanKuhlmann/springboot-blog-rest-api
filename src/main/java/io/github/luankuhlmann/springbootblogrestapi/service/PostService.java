package io.github.luankuhlmann.springbootblogrestapi.service;

import io.github.luankuhlmann.springbootblogrestapi.dto.PostDto;
import io.github.luankuhlmann.springbootblogrestapi.dto.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
