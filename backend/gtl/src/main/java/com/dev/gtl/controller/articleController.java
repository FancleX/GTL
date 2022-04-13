package com.dev.gtl.controller;

import java.util.List;
import java.util.Map;

import com.dev.gtl.model.article.Article;
import com.dev.gtl.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/content")
public class ArticleController {
    
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // get all articles
    @GetMapping("/explorer")
    public List<Article> getArticles() {
        return articleService.getArticles();
    }

    // get a specific article
    @GetMapping("/{article}")
    public @ResponseBody Article getArticleById(@PathVariable(value = "articleId") String id) {
        return articleService.getArticleById(id);
    }

    @PostMapping("/user/add") 
    public @ResponseBody void addArticle(@PathVariable(value = "article") String article) {
        
    }


}
