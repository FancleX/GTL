package com.dev.gtl.repository;

import com.dev.gtl.model.article.Article;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    
}
