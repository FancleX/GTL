package com.dev.gtl.controller;

import java.util.List;

import com.dev.gtl.model.article.Article;
import com.dev.gtl.response.BaseResponse;
import com.dev.gtl.service.ArticleService;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
/**
 * Article Controller.
 */
public class ArticleController {

    /**
     * Article service
     */
    private final ArticleService articleService;

    /**
     * Inject Article service.
     * 
     * @param articleService article service
     */
    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /* #################################################################################### */
    // article
    /**
     * Get all articles.
     * 
     * @return all articles
     */
    @GetMapping("/explorer")
    public BaseResponse<List<Article>> getArticles() {
        return articleService.getArticles();
    }

    /**
     * Get a specific article.
     * 
     * @param id article Id
     * @return the specific article
     */
    @GetMapping("/search/{articleId}")
    public BaseResponse<Article> getArticleById(@PathVariable(value = "articleId") Long id) {
        return articleService.getArticleById(id);
    }

    /**
     * Create an article.
     *  
     * @param article article
     * @param id user Id
     * @return article id createby user id
     */
    @PostMapping("/add/{userId}")
    public BaseResponse<String> addArticle(@RequestBody Article article, @PathVariable(value = "userId") Long id) {
        return articleService.addArticle(article, id);
    }

    /**
     * Delete an article.
     * 
     * @param id the id of the article that will be deleted
     * @return the id of the deleted article
     */
    @DeleteMapping("/delete/{articleId}")
    public BaseResponse<String> deleteArticle(@PathVariable(value = "articleId") Long id) {
        return articleService.deleteArticle(id);
    }

    /**
     * Modify an article.
     * 
     * @param article the article needs to be modified
     * @return status "updated"
     */
    @PutMapping("/edit")
    public BaseResponse<String> editArticle(@RequestBody Article article) {
        return articleService.editArticle(article);
    }

    /**
     * Add a comment.
     * JSON format {"userId": xxx, "articleId": xxx, "message": "xxxx"}
     * 
     * @param comment the comment to be added
     * @return message 
     */
    @PostMapping("/addComment")
    public BaseResponse<String> addComment(@RequestBody String comment) {
        return articleService.addComment(comment);
    }

    /**
     * Delete a comment.
     * 
     * @param id id of the comment
     * @return message
     */
    @DeleteMapping("/delete/comment/{commentId}")
    public BaseResponse<String> deleteComment(@PathVariable(value = "commentId") Long id) {
        return articleService.deleteComment(id);
    }

    /**
     * Get preview article (id, img, header, partial content).
     * 
     * @return JSON array
     */
    @GetMapping("/preview")
    public BaseResponse<JSONArray> getPreview() {
        return articleService.getPreview();
    }

    /**
     * Get user id that who made this comment.
     * 
     * @param articleId article Id
     * @return the username of those ids
     */
    @GetMapping("/getCommentMaker/{articleId}")
    public BaseResponse<List<Long>> getCommentMaker(@PathVariable(value = "articleId") Long articleId) {
        return articleService.getCommentMaker(articleId);
    }

}
