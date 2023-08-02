package io.github.luankuhlmann.springbootblogrestapi.service.impl;

import io.github.luankuhlmann.springbootblogrestapi.dto.CommentDto;
import io.github.luankuhlmann.springbootblogrestapi.entity.Comment;
import io.github.luankuhlmann.springbootblogrestapi.entity.Post;
import io.github.luankuhlmann.springbootblogrestapi.exception.ResourceNotFoundException;
import io.github.luankuhlmann.springbootblogrestapi.repository.CommentRepository;
import io.github.luankuhlmann.springbootblogrestapi.repository.PostRepository;
import io.github.luankuhlmann.springbootblogrestapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    //@Autowired not needed because repository have only one constructor
    public ComentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    private CommentDto mapToDTO(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(commentDto.getBody());

        return commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());

        return comment;
    }

    @Override
    public CommentDto createComment(Long postId, CommentDto commentDto) {

        Comment comment = mapToEntity(commentDto);

        // retrieve post entity by id
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        // set post to comment entity
        comment.setPost(post);

        // save comment entity to DB
        Comment newComment = commentRepository.save(comment);

        return mapToDTO(newComment);
    }

}
