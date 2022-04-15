package com.dev.gtl.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.dev.gtl.model.article.Article;
import com.dev.gtl.repository.ArticleRepository;
import com.dev.gtl.repository.CommentRepository;
import com.dev.gtl.repository.ParagraphRepository;
import com.dev.gtl.repository.QuestionRepository;
import com.dev.gtl.response.BaseResponse;
import com.dev.gtl.response.ResultStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ArticleService{

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;
    private final ParagraphRepository paragraphRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, 
                            CommentRepository commentRepository,
                            ParagraphRepository paragraphRepository,
                            QuestionRepository questionRepository) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
        this.paragraphRepository = paragraphRepository;
        this.questionRepository = questionRepository;
    }

    public BaseResponse<List<Article>> getArticles() {
        try {
            List<Article> data = articleRepository.findAll();
            return ResultStatus.success(data);
        } catch (Exception e) {
            return ResultStatus.fail("no articles in database");
        }
    }

    public BaseResponse<Article> getArticleById(String id){
        try {
            Optional<Article> target = articleRepository.findById(Long.parseLong(id));
            if (!target.isPresent()) {
                throw new NotFoundException();
            }
            Article data = target.get();
            return ResultStatus.success(data);
        } catch (IllegalArgumentException e) {
            return ResultStatus.fail("invalid id");
        } catch (NotFoundException e) {
            return ResultStatus.fail("the article doesn't exist");
        }
    }

    public BaseResponse<Long> addArticle(Article article) {
        try {
            articleRepository.save(article);
            return ResultStatus.success(article.getId());
        } catch (IllegalArgumentException e) {
            return ResultStatus.fail("empty article");
        }
    }

    @Transactional
    public BaseResponse<Long> addComment(Long id, String comment) {
        try {
            Optional<Article> target = articleRepository.findById(id);
            if (!target.isPresent()) {
                throw new NotFoundException();
            }
            Article article = target.get();
            article.addComments(comment);
            return ResultStatus.success(article.getId());
        } catch (IllegalArgumentException e) {
            return ResultStatus.fail("invalid id");
        } catch (NotFoundException e) {
            return ResultStatus.fail("the article doesn't exist");
        }
    }

    @Transactional
    public BaseResponse<Long> deleteComment(Long id, String comment) {
        try {
            if (comment.isEmpty()) {
                throw new IllegalArgumentException();
            }
            Optional<Article> target = articleRepository.findById(id);
            if (!target.isPresent()) {
                throw new NotFoundException();
            }
            Article article = target.get();
            Iterator<String> it = article.getComments().iterator();
            while (it.hasNext()) {
                String userComment = it.next();
                if (userComment == comment) {
                    it.remove();
                }
            }
            return ResultStatus.success(article.getId());
        } catch (IllegalArgumentException e) {
            return ResultStatus.fail("invalid id or empty comment");
        } catch (NotFoundException e) {
            return ResultStatus.fail("the article doesn't exist");
        }
    }


}
