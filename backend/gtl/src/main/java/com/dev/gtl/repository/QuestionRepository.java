package com.dev.gtl.repository;

import com.dev.gtl.model.article.Question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    
}
