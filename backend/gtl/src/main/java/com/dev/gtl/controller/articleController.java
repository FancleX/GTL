package com.dev.gtl.controller;

import java.util.List;
import java.util.Map;

import com.dev.gtl.model.article.Article;
import com.dev.gtl.response.BaseResponse;
import com.dev.gtl.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public @ResponseBody BaseResponse<List<Article>> getArticles() {
        return articleService.getArticles();
    }

    // get a specific article
    @GetMapping("/{articleId}")
    public BaseResponse<Article> getArticleById(@PathVariable(value = "articleId") String id) {
        return articleService.getArticleById(id);
    }

    // create a article
    @PostMapping("/user/add") 
    public BaseResponse<Long> addArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }

    // add comments that updates the article
    @PutMapping("/user/addComment/{articleId}/{comment}")
    public BaseResponse<Long> addComment(@PathVariable Map<String, String> res) {
        Long articleId = Long.parseLong(res.get("articleId"));
        String comment = res.get("comment");
        return articleService.addComment(articleId, comment);
    }
     


}
