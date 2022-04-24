package com.dev.gtl.controller;

import java.util.List;

import com.dev.gtl.model.article.Article;
import com.dev.gtl.response.BaseResponse;
import com.dev.gtl.service.ArticleService;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /* #################################################################################### */
    // article
    // get all articles
    @GetMapping("/explorer")
    public BaseResponse<List<Article>> getArticles() {
        return articleService.getArticles();
    }

    // get a specific article
    @GetMapping("/search/{articleId}")
    public BaseResponse<Article> getArticleById(@PathVariable(value = "articleId") Long id) {
        return articleService.getArticleById(id);
    }

    // create an article
    @PostMapping("/add/{userId}")
    public BaseResponse<String> addArticle(@RequestBody Article article, @PathVariable(value = "userId") Long id) {
        return articleService.addArticle(article, id);
    }

    // delete an article
    @DeleteMapping("/delete/{articleId}")
    public BaseResponse<String> deleteArticle(@PathVariable(value = "articleId") Long id) {
        return articleService.deleteArticle(id);
    }

    // modify an article
    @PutMapping("/edit")
    public BaseResponse<String> editArticle(@RequestBody Article article) {
        return articleService.editArticle(article);
    }

    // add comment
    // JSON format {"userId": xxx, "articleId": xxx, "message": "xxxx"}
    @PostMapping("/addComment")
    public BaseResponse<String> addComment(@RequestBody String comment) {
        return articleService.addComment(comment);
    }

    // delete comment
    @DeleteMapping("/delete/comment/{commentId}")
    public BaseResponse<String> deleteComment(@PathVariable(value = "commentId") Long id) {
        return articleService.deleteComment(id);
    }

    // get preview article (id, img, header, partial content)
    @GetMapping("/preview")
    public BaseResponse<JSONArray> getPreview() {
        return articleService.getPreview();
    }

    // get user id that who made this comment
    @GetMapping("/getCommentMaker/{articleId}")
    public BaseResponse<List<Long>> getCommentMaker(@PathVariable(value = "articleId") Long articleId) {
        return articleService.getCommentMaker(articleId);
    }

}
