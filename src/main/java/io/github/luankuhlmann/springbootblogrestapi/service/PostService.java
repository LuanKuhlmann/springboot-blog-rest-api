package io.github.luankuhlmann.springbootblogrestapi.service;

import io.github.luankuhlmann.springbootblogrestapi.dto.PostDto;

public interface PostService {

    PostDto createPost(PostDto postDto);
}
