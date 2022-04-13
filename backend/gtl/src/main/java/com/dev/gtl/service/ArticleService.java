package com.dev.gtl.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.dev.gtl.model.article.Article;
import com.dev.gtl.repository.ArticleRepository;
import com.dev.gtl.response.BaseResponse;
import com.dev.gtl.response.ResultStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;


@Service
public class ArticleService{
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
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

}
