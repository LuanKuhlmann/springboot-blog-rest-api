package io.github.luankuhlmann.springbootblogrestapi.repository;

import io.github.luankuhlmann.springbootblogrestapi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);
}
