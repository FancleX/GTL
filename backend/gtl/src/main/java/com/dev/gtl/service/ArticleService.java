package com.dev.gtl.service;

import java.util.List;
import java.util.Optional;

import com.dev.gtl.model.article.Article;
import com.dev.gtl.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticleService{
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(String id) {
        Optional<Article> target = articleRepository.findById(Long.parseLong(id));
        return target.get();
    }

}
