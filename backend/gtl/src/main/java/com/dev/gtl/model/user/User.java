package com.dev.gtl.model.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.dev.gtl.model.article.Article;
import com.dev.gtl.model.article.Comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_learner")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_account")
    private Account account;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_bookmark")
    private List<Article> bookMarks;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_contribution")
    private List<Article> contribution;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_comments")
    private List<Comment> comments;

    // public User(Account account) {
    //     this.account = account;
    // }

}
