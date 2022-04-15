package com.dev.gtl.service;

import java.util.List;

import com.dev.gtl.model.article.Article;
import com.dev.gtl.repository.ArticleRepository;
import com.dev.gtl.response.BaseResponse;
import com.dev.gtl.response.ResultStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    /*
     * #############################################################################
     * #######
     */
    // article
    public BaseResponse<List<Article>> getArticles() {
        List<Article> data = articleRepository.findAll();
        return ResultStatus.success(data);
    }

    public BaseResponse<Article> getArticleById(Long id) {
        if (articleRepository.existsById(id)) {
            Article article = articleRepository.getById(id);
            return ResultStatus.success(article);
        } 
        return ResultStatus.fail("the article doesn't exist");
    }

    public BaseResponse<Long> addArticle(Article article) {
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
        return ResultStatus.success(article.getId());
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



    // /*
    // ####################################################################################
    // */
    // // comment
    // @Transactional
    // public BaseResponse<Long> addComment(Long id, String comment) {
    // try {
    // Optional<Article> target = articleRepository.findById(id);
    // if (!target.isPresent()) {
    // throw new NotFoundException();
    // }
    // Article article = target.get();
    // article.addComments(comment);
    // return ResultStatus.success(article.getId());
    // } catch (IllegalArgumentException e) {
    // return ResultStatus.fail("invalid id");
    // } catch (NotFoundException e) {
    // return ResultStatus.fail("the article doesn't exist");
    // }
    // }

    // @Transactional
    // public BaseResponse<Long> deleteComment(Long id, String comment) {
    // try {
    // if (comment.isEmpty()) {
    // throw new IllegalArgumentException();
    // }
    // Optional<Article> target = articleRepository.findById(id);
    // if (!target.isPresent()) {
    // throw new NotFoundException();
    // }
    // Article article = target.get();
    // Iterator<String> it = article.getComments().iterator();
    // while (it.hasNext()) {
    // String userComment = it.next();
    // if (userComment == comment) {
    // it.remove();
    // }
    // }
    // return ResultStatus.success(article.getId());
    // } catch (IllegalArgumentException e) {
    // return ResultStatus.fail("invalid id or empty comment");
    // } catch (NotFoundException e) {
    // return ResultStatus.fail("the article doesn't exist");
    // }
    // }

    /*
     * #############################################################################
     * #######
     */
    // paragraphs

    /*
     * #############################################################################
     * #######
     */
    // questions

}
