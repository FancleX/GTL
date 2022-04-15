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
@Table(name = "article_paragraph")
@Data
public class Paragraph {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order")
    private Byte order;

    @Column(name = "subHeader")
    private String subHeader;

    @Column(name = "content")
    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id")
    private Article article;


    public Paragraph() {
    }


    public Paragraph(Byte order, String subHeader, String content, Article article) {
        this.order = order;
        this.subHeader = subHeader;
        this.content = content;
        this.article = article;
    }



}
