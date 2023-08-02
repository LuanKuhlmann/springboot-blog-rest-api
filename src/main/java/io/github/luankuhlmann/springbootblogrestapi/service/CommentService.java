package io.github.luankuhlmann.springbootblogrestapi.service;

import io.github.luankuhlmann.springbootblogrestapi.dto.CommentDto;

public interface CommentService {
    CommentDto createComment(Long postId, CommentDto commentDto);
}
