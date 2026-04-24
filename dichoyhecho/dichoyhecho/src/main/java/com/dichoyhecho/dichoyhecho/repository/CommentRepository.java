package com.dichoyhecho.dichoyhecho.repository;

import com.dichoyhecho.dichoyhecho.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
