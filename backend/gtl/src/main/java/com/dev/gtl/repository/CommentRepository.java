package com.dev.gtl.repository;

import com.dev.gtl.model.article.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    
}
