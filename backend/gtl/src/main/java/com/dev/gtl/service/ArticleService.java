package com.dev.gtl.service;

import java.util.List;
import java.util.Optional;

import com.dev.gtl.model.article.Article;
import com.dev.gtl.model.article.Comment;
import com.dev.gtl.repository.ArticleRepository;
import com.dev.gtl.repository.CommentRepository;
import com.dev.gtl.response.BaseResponse;
import com.dev.gtl.response.ResultStatus;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, CommentRepository commentRepository) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }

    /*
     * #############################################################################
     */
    // article
    public BaseResponse<List<Article>> getArticles() {
        List<Article> data = articleRepository.findAll();
        return ResultStatus.success(data);
    }

    public BaseResponse<Article> getArticleById(Long id) {
        if (articleRepository.existsById(id)) {
            Optional<Article> article = articleRepository.findById(id);
            return ResultStatus.success(article.get());
        } 
        return ResultStatus.fail("the article doesn't exist");
    }

    @Transactional
    public BaseResponse<String> addArticle(Article article, Long id) {
        // don't accept an article with an empty header
        if (article.getHeader() == null) {
            return ResultStatus.fail("header can't be empty");
        }
        // check if the article exists
        List<Article> articles = articleRepository.findAll();
        for (Article art : articles) {
            if (article.getHeader().equals(art.getHeader())) {
                return ResultStatus.fail("the article could exist");
            }
        }
        // successfully save and return the article id
        articleRepository.save(article);
        // update author
        articleRepository.markAuthor(article.getId(), id);
        return ResultStatus.success("article: " + article.getId() + " created by: " + id);
    }

    @Transactional
    public BaseResponse<String> deleteArticle(Long id) {
        // check the id if is existed
        if (!articleRepository.existsById(id)) {
            return ResultStatus.fail("the article doesn't exist");
        }
        // delete an article should delete all the contents that belongs to this article
        Article article = articleRepository.getById(id);
        // delete the paragraph of the article
        article.getParagraphs().clear();
        // delete the questions of the article
        article.getQuestions().clear();
        // delete the comments of the article
        article.getComments().clear();

        articleRepository.delete(article);
        return ResultStatus.success(null);
    }

    public BaseResponse<String> editArticle(Article article) {
        Article oldArticle = articleRepository.findById(article.getId()).get();
        merge(article, oldArticle);
        articleRepository.save(oldArticle);
        return ResultStatus.success("updated");   
    }

    public static <T> void merge(T source, T target) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(source, target);
    }

    @Transactional
    public BaseResponse<String> addComment(String comment) {
        // parse json file
        try {
            Object obj = new JSONParser().parse(comment);
            JSONObject jo = (JSONObject) obj;
            Long userId = (Long) jo.get("userId");
            Long articleId = (Long) jo.get("articleId");
            String message = (String) jo.get("message");
            // System.out.println(message);

            // check comment if is valid
            if ((message == null) || ("".equals(message))) {
                return ResultStatus.fail("comment cannot be empty");
            }
            Article article = articleRepository.findById(articleId).get();
            Comment newComment = new Comment();
            newComment.setMessage(message);
            article.getComments().add(newComment);
            commentRepository.save(newComment);
            // bind comment with the user 
            articleRepository.CommentCreatedBy(userId, newComment.getId());
            return ResultStatus.success("comment added");
        } catch (ParseException e) {
            return ResultStatus.fail("Illegal format");
        }
    }  

    public BaseResponse<String> deleteComment(Long id) {
        if (!commentRepository.existsById(id)) {
            return ResultStatus.fail("comment not found");
        }
        commentRepository.deleteById(id);
        return ResultStatus.success("comment deleted");
    }
}
