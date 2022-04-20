package com.dev.gtl.repository;

import java.util.Optional;

import com.dev.gtl.model.user.Account;
import com.dev.gtl.model.user.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    
    @Modifying
    @Query(value = "UPDATE article SET user_bookmark = :userId WHERE id = :articleId", nativeQuery = true)
    void addBookMark(@Param("userId") Long userId, @Param("articleId") Long articleId);


}
