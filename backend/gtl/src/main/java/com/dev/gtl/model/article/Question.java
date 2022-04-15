package com.dev.gtl.model.article;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "article_question")
@Data
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripton")
    private String description;

    @Column(name = "answer")
    private String answer;

    @Column(name = "explaination")
    private String explaination;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id")
    private Article article; 


    public Question() {
    }


    public Question(String description, String answer, String explaination, Article article) {
        this.description = description;
        this.answer = answer;
        this.explaination = explaination;
        this.article = article;
    }


}
