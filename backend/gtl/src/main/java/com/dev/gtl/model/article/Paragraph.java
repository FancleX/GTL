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
@Table(name = "article_paragraph")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paragraph {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subHeader", nullable = true)
    private String subHeader;

    @Column(name = "content", columnDefinition="text")
    private String content;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "paragraph_id", nullable = true)
    private List<Question> questions;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "paragraph_id", nullable = true)
    private List<ImgSrc> imgSrcList;
}
