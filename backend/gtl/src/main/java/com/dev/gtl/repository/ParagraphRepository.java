package com.dev.gtl.repository;

import com.dev.gtl.model.article.Paragraph;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParagraphRepository extends JpaRepository<Paragraph, Long> {
    
}
