package com.dev.gtl.model.article;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "article")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "header")
    private String header;

    @Column(name = "imgUrl")
    private String imgUrl;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id")
    private List<Paragraph> paragraphs;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id")
    private List<Comment> comments;


    // public Article(String header, List<Paragraph> paragraphs, List<Question> questions, List<Comment> comments) {
    //     this.header = header;
    //     this.paragraphs = paragraphs;
    //     this.questions = questions;
    //     this.comments = comments;
    // }

}
