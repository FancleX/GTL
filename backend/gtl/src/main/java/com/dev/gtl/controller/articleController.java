package com.dev.gtl.controller;

import java.util.List;
import java.util.Map;

import com.dev.gtl.model.article.Article;
import com.dev.gtl.response.BaseResponse;
import com.dev.gtl.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

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

    // create a article
    @PostMapping("/add")
    public BaseResponse<Long> addArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }

    // delete a article
    @DeleteMapping("/delete/{articleId}")
    public BaseResponse<String> deleteArticle(@PathVariable(value = "articleId") Long id) {
        return articleService.deleteArticle(id);
    }

    // /* #################################################################################### */
    // // comment
    // // get comment of an article
    // @GetMapping("")
    // public @ResponseBody BaseResponse<List<Article>> getComments() {
    //     return articleService.getArticles();
    // }

    // // add comments
    // @PostMapping("/user/addComment/{articleId}/{comment}")
    // public BaseResponse<Long> addComment(@PathVariable Map<String, String> res) {
    //     Long articleId = Long.parseLong(res.get("articleId"));
    //     String comment = res.get("comment");
    //     return articleService.addComment(articleId, comment);
    // }

    // // delete comments
    // @DeleteMapping("/user/deleteComment/{articleId}/{comment}")
    // public BaseResponse<Long> deleteComment(@PathVariable Map<String, String> res) {
    //     Long articleId = Long.parseLong(res.get("articleId"));
    //     String comment = res.get("comment");
    //     return articleService.deleteComment(articleId, comment);
    // }

    // /* #################################################################################### */
    // // paragraphs
    // // get paragraphs of an article
    // @GetMapping("")
    // public @ResponseBody BaseResponse<List<Article>> getParagraphs() {
    //     return articleService.getArticles();
    // }

    // // add paragraphs
    // @PostMapping("")
    // public BaseResponse<Long> addParagraphs(@PathVariable Map<String, String> res) {
    //     Long articleId = Long.parseLong(res.get("articleId"));
    //     String comment = res.get("comment");
    //     return articleService.addComment(articleId, comment);
    // }

    // // delete paragraphs
    // @DeleteMapping("/user/deleteComment/{articleId}/{comment}")
    // public BaseResponse<Long> deleteParagraphs(@PathVariable Map<String, String> res) {
    //     Long articleId = Long.parseLong(res.get("articleId"));
    //     String comment = res.get("comment");
    //     return articleService.deleteComment(articleId, comment);
    // }

    // /* #################################################################################### */
    // // question
    // // get questions of an article
    // @GetMapping("")
    // public @ResponseBody BaseResponse<List<Article>> getQuestions() {
    //     return articleService.getArticles();
    // }

    // // add questions
    // @PostMapping("")
    // public BaseResponse<Long> addQuestion(@PathVariable Map<String, String> res) {
    //     Long articleId = Long.parseLong(res.get("articleId"));
    //     String comment = res.get("comment");
    //     return articleService.addComment(articleId, comment);
    // }

    // // delete questions
    // @DeleteMapping("")
    // public BaseResponse<Long> deleteQuestion(@PathVariable Map<String, String> res) {
    //     Long articleId = Long.parseLong(res.get("articleId"));
    //     String comment = res.get("comment");
    //     return articleService.deleteComment(articleId, comment);
    // }

}
