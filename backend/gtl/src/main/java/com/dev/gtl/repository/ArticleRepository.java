package com.dev.gtl.repository;

import java.util.List;

import com.dev.gtl.model.article.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    
    @Modifying
    @Query(value = "UPDATE article SET user_contribution = :authorId WHERE id = :articleId", nativeQuery = true)
    void markAuthor(@Param("articleId") Long articleId, @Param("authorId") Long authorId);

    @Modifying
    @Query(value = "UPDATE article_comment SET user_comments = :userId WHERE id = :commentId", nativeQuery = true)
    void CommentCreatedBy(@Param("userId") Long userId, @Param("commentId") Long commentId);

    @Query(value = "SELECT user_comments FROM article_comment WHERE article_id = :articleId", nativeQuery = true)
    List<Long> getCommentMaker(@Param("articleId") Long articleId);

}
