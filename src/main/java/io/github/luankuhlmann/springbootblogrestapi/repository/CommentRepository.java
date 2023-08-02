package io.github.luankuhlmann.springbootblogrestapi.repository;

import io.github.luankuhlmann.springbootblogrestapi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
